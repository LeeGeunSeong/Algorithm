import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링_이근성_unionfind {
	static int N,ans=Integer.MAX_VALUE, INF = 10000;
	static int[] arr,input,parents;
	static int[][] adj;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		input = new int[N+1];
		adj = new int[N+1][N+1];
		parents = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) 
			input[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken());
			for (int j = 0; j < end; j++) {
				adj[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}
		dfs(1);
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
	private static void dfs(int cnt) {
		if(ans == 0) return;
		if(cnt == N+1) {
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if(arr[i] ==1) count++;
			}
			if(count == N || count == 0) return;
			
			Arrays.fill(parents, -1);
			if(adjCheck()) {
				int sum1 = 0,sum2 = 0;
				for (int i = 1; i <= N; i++) {
					if(arr[i] == 1) 
						sum1 += input[i];
					else 
						sum2 += input[i];
				}
				int min = Math.abs(sum1 - sum2);
				ans = Math.min(min, ans);
			}
			return;
		}
		arr[cnt] = 1;
		dfs(cnt+1);
		arr[cnt] = 0;
		dfs(cnt+1);
		
	}
	private static boolean adjCheck() {
		System.out.print("");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j) continue;
				if(arr[i] == 1 && arr[j] == 1 && adj[i][j] == 1) {
					union(i,j);
				}
				else if(arr[i] == 0 && arr[j] == 0 && adj[i][j] == 1) {
					union(i,j);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j) continue;
				if(arr[i] == 1 && arr[j] == 1 && union(i,j)) {
					return false;
				}
				else if(arr[i] == 0 && arr[j] == 0 && union(i,j)) {
					return false;
				}
			}
		}
		return true;
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	private static int find(int a) {
		if(parents[a] < 0) return a;
		
		return parents[a] = find(parents[a]);
	}
}

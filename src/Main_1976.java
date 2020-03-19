import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1976 {
	static int N,M;
	static int[] parents;
	static int[][] adj;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		adj = new int[N][N];
		
		Arrays.fill(parents, -1);
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				if(adj[i][j] == 1) union(i+1,j+1);
			}
					
		}
		st = new StringTokenizer(br.readLine());
		int bef = 0, cur = 0;
		bef = Integer.parseInt(st.nextToken());
		for (int i = 1; i < M; i++) {
			cur = Integer.parseInt(st.nextToken());
			if(union(bef,cur)) {
				flag = true;
				System.out.println("NO");
				break;
			}
			bef = cur; 
		}
		if(!flag) System.out.println("YES");
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

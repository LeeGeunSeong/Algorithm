import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11724 {
	static int N,M,ans;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		Arrays.fill(parents, -1);
		int[][] arr = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken())-1;
			arr[i][1] = Integer.parseInt(st.nextToken())-1;
			union(arr[i][0],arr[i][1]);
		}
		for (int i = 0; i < N; i++) 
			if(parents[i] < 0) ans++;
		
		System.out.println(ans);
	}
	private static boolean union(int u, int v) {
		int aRoot = find(u);
		int bRoot = find(v);
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

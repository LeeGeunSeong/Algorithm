import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10971 {
	static int N, min,start,INF;
	static int[][] dp, adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		dp = new int[N][1<<N];
		adj = new int[N][N];
		INF = 1000000000;
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				adj[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
				Arrays.fill(dp[j], INF);
			start = i;
			min = Math.min(min, solve(i,1<<i));
		}
		System.out.println(min);
	}
	private static int solve(int idx, int v) {
		if((v == (1 << N) -1) && adj[idx][start] > 0) {
			return adj[idx][start];
		}
		if(dp[idx][v] < INF) return dp[idx][v];
		
		for (int i = 0; i < adj.length; i++) {
			if((v & 1<<i) != 0 || adj[idx][i] == 0) continue;
			dp[idx][v] = Math.min(dp[idx][v], adj[idx][i] + solve(i,v | 1<<i));
		}
		return dp[idx][v];
	}
}

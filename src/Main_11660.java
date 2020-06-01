import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -dp[i-1][j-1] + dp[i-1][j] + dp[i][j-1] + map[i][j];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int sum = dp[ex][ey] + dp[sx-1][sy-1] - dp[sx-1][ey] - dp[ex][sy-1];
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
	}
}

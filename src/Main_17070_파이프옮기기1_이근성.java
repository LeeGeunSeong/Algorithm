import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_17070_파이프옮기기1_이근성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		long[][][] dp = new long[N+1][N+1][3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}// end input
		dp[0][1][2] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if(map[i+1][j] == 0) dp[i+1][j][0] += dp[i][j][0] + dp[i][j][1]; // 세로
				if(map[i][j+1] == 0) dp[i][j+1][2] += dp[i][j][1] + dp[i][j][2]; // 가로
				if(map[i+1][j] == 0 && map[i][j+1] == 0 && map[i+1][j+1] == 0) // 대각선
					dp[i+1][j+1][1] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
			}
		}
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
}
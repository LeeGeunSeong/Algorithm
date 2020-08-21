import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			long[][] dp = new long[N+1][M+1];
			
			for (int i = 0; i <= M; i++) 
				dp[1][i] = i;
			
			for (int i = 2; i <= N; i++) 
				for (int j = 1; j <= M; j++) 
					for (int k = j; k >= 1; k--) 
						dp[i][j] += dp[i-1][k-1];
			System.out.println(dp[N][M]);
		}
	}
}

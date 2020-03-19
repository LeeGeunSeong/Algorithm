import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N][10];
		long ans = 0;
		int rem = 1000000000;
		for (int i = 1; i < 10; i++) dp[0][i] = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if(j==0) dp[i][j] = dp[i-1][j+1];
				else if(j==9) dp[i][j] = dp[i-1][j-1];
				else dp[i][j] = (dp[i-1][j-1]%rem + dp[i-1][j+1]%rem)%rem;
			}
		}
		for (int i = 0; i < 10; i++) {
			ans += dp[N-1][i];
		}
		System.out.println(ans%rem);
	}
}

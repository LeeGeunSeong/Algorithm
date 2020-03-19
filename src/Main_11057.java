import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		for (int i = 0; i < 10; i++) dp[1][i] = 1; 
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) dp[i][0] = (dp[i][0]%10007 + dp[i-1][j]%10007)%10007;
			for (int j = 1; j < 10; j++) dp[i][j] = (dp[i][j-1]%10007 - dp[i-1][j-1]%10007 + 10007)%10007;
		}
		int sum = 0;
		for (int i = 0; i < 10; i++) 
			sum = (sum%10007 + dp[N][i]%10007)%10007;
		System.out.println(sum%10007);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) 
			dp[i] = i;
		for (int i = 2; i <= N; i++) 
			for (int j = 2; j*j <= i; j++) 
				dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
		System.out.println(dp[N]);
	}
}

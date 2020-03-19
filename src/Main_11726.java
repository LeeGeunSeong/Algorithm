import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[1001];
		int mod = 10007;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < dp.length; i++) 
			dp[i] = (dp[i-1]%mod + dp[i-2]%mod)%mod;
		
		System.out.println(dp[N]%mod);
	}
}

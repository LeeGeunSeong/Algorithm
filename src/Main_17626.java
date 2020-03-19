import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17626 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] pow = new int[((int)Math.sqrt(50000))+1];
		
		for (int i = 1; i < pow.length; i++) 
			pow[i] = i*i;
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			int min = 1000000000;
			for (int j = 1; pow[j] <= i; j++) {
				min = Math.min(min, dp[i-pow[j]]);
			}
			dp[i] = min + 1;
		}
		
		System.out.println(dp[N]);
	}
}

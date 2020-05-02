import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		
		for (int i = 0; i < N; i++) 
			coin[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(coin);
		int[] dp = new int[K+1];
		Arrays.fill(dp, 1000000000);
		dp[0] = 0;
		dp[coin[0]] = 1;
		for (int i = coin[0]+1; i < dp.length; i++) {
			for (int j = 0; j < N; j++) {
				if(i-coin[j] < 0) continue;
				dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1); 
			}
		}
		
		System.out.println(dp[K]==1000000000?-1:dp[K]);
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			for (int j = 1; j < k+1; j++) 
				if(j-coin >= 0)
					dp[j] += dp[j-coin];
		}
		System.out.println(dp[k]);
	}
}

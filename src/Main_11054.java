import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11054 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		int[] dp2 = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dp, 1);
		Arrays.fill(dp2, 1);
		int ans = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			ans = Math.max(ans, dp[i]);
		}
		for (int i = N-1; i >= 0; i--) {
			for (int j = N-1; j >= i; j--) {
				if(arr[i] > arr[j])
					dp2[i] = Math.max(dp2[j]+1, dp2[i]);
			}
		}
		for (int i = 0; i < N; i++) 
			ans = Math.max(ans, dp[i]+dp2[i]);
		
		System.out.println(ans-1);
	}
}

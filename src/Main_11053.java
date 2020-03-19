import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dp, 1);
		int ans = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}

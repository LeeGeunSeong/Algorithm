import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501 {
	static int N,ans;
	static int[][] arr;
	// dp
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		StringTokenizer st; 
//		int[][] arr = new int[N+1][2];
//		for (int i = 1; i <= N; i++) {
//			st = new StringTokenizer(br.readLine());
//			arr[i][0] = Integer.parseInt(st.nextToken());
//			arr[i][1] = Integer.parseInt(st.nextToken());
//		}
//		int[] dp = new int[N+2];
//		int max = 0;
//		for (int i = 1; i <= N; i++) {
//			dp[i] = Math.max(dp[i], dp[i-1]);
//			if(i+arr[i][0]-1 <= N)
//				dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i] + arr[i][1]);
//		}
//		for (int i = 0; i < dp.length; i++) 
//			max = Math.max(max, dp[i]);
//		System.out.println(max);
//	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][2];
		
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1,0);
		
		System.out.println(ans);
	}
	private static void dfs(int day, int sum) {
		if(day > N+1) return;
		
		ans = Math.max(ans, sum);
		
		for (int i = day; i <= N; i++) {
			dfs(i+arr[i][0],sum+arr[i][1]);
		}
	}
}

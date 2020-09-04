import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		boolean[][] dp = new boolean[N+1][N+1];
		for (int i = 1; i < N; i++) {
			dp[i][i] = true;
			if(arr[i] == arr[i+1]) dp[i][i+1] = true;
		}
		dp[N][N] = true;
		for (int i = 2; i < N; i++) {
			for (int j = 1; i+j <= N; j++) {
				if(arr[j] == arr[i+j] && dp[j+1][i+j-1])
					dp[j][i+j] = true;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append((dp[s][e]?1:0) +"\n");
		}
		System.out.println(sb.toString());
	}
}

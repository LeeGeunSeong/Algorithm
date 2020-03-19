import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18790 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N];
		int[] arr = new int[2*N];
		boolean[][][] dp = new boolean[2*N][N+1][N];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < 2*N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
			count[arr[i]]++;
		}
		dp[0][0][0] = true;
		if(N==1) {
			System.out.println(0);
		}else if(count[1] >= N) {
			for (int i = 0; i < N; i++) 
				System.out.print(1 + " ");
		}else {
			for (int i = 0; i < 2*N-1; i++) {
				for (int j = 0; j <= i && j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(dp[i][j][k]) {
							dp[i+1][j][k] = dp[i][j][k];
							dp[i+1][j+1][(k + arr[i+1])%N] = dp[i][j][k];
						}
					}
				}
			}
			int j = N;
			int k = 0;
			for (int i = 2*N-1; i > 1; i--) {
				if(j>0 && dp[i][j][k]) {
					if(dp[i-1][j-1][(k-arr[i]+N)%N]) {
						sb.append(arr[i] + " ");
						j--; k = (k-arr[i]+N)%N;
					}
				}
			}
		}
		System.out.println(sb.toString());
		
	}

}

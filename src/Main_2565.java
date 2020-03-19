import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2565 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] AB = new int[N][2];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			AB[i][0] = Integer.parseInt(st.nextToken());
			AB[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(AB,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		Arrays.fill(dp, 1);
		int ans = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(AB[i][1] > AB[j][1])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(N-ans);
	}
}

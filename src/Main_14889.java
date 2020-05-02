import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889 {
	static int ans, N;
	static boolean[] team;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		team = new boolean[N];
		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		ans = Integer.MAX_VALUE;
		divide(0,0);
		System.out.println(ans);
	}
	private static void divide(int cnt, int idx) {
		if(cnt==N && idx==N/2) {
			int sum1=0, sum2=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					if(team[i] == team[j]) {
						if(team[i]) sum1 += arr[i][j];
						else sum2 += arr[i][j];
					}
				}
			}
			ans = Math.min(ans,Math.abs(sum1-sum2));
			return;
		}else if(idx > N/2 || cnt > N-1) return;
		
		team[cnt] = true;
		divide(cnt+1, idx+1);
		team[cnt] = false;
		divide(cnt+1, idx);
	}
}

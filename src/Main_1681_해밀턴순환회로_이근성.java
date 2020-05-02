import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순환회로_이근성 {
	static int N,ans;
	static int[] arr;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// end input
		arr = new int[N-1];
		int INF = 2400;
		ans = INF;
		dfs(0,0,0,0);
		System.out.println(ans);
	}

	private static void dfs(int cnt, int flag, int bef, int sum) {
		if(cnt == N-1) {
			int tmp = map[bef][0];
			if(tmp == 0) return;
			sum += tmp;
			ans = Math.min(ans, sum);
			return;
		}
		if(sum > ans) return;
		for (int i = 1; i < N; i++) {
			if((flag & (1<<i)) != 0) continue;
			int go = map[bef][i];
			if(go == 0) continue;
			dfs(cnt+1, flag | (1<<i), i, sum+go);
		}
		
	}
}

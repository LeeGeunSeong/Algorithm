import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12100 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		if(N==1) System.out.println(map[0][0]);
		else{
			dfs(map,0);
			System.out.println(ans);
		}
	}
	private static void dfs(int[][] m, int cnt) {
		if(cnt==5) {
			ans = Math.max(ans, calc(m));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int[][] m2 = new int[N][N];
			for (int j = 0; j < m.length; j++) 
				m2[j] = Arrays.copyOf(m[j], N);
			dfs(move(m2,i),cnt+1);
		}
	}
	private static int calc(int[][] m) {
		int ret = 0;
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				ret = Math.max(m[i][j], ret);
		return ret;
	}
	private static int[][] move(int[][] m, int dir) {
		boolean[][] v = new boolean[N][N];
		if(dir==0) {
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(m[i][j] == 0) continue;
					int cnt = 1;
					while(cnt <= i && m[i-cnt][j] == 0) {
						m[i-cnt][j] = m[i-cnt+1][j];
						m[i-cnt+1][j] = 0;
						cnt++;
					}
					if(cnt <= i && m[i-cnt][j] == m[i-cnt+1][j]) {
						if(v[i-cnt][j]) continue;
						v[i-cnt][j] = true;
						m[i-cnt][j] *= 2;
						m[i-cnt+1][j] = 0;
					}
				}
			}
		}else if(dir==1) {
			for (int i = N-2; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					if(m[i][j] == 0) continue;
					int cnt = 1;
					while(cnt + i < N && m[i+cnt][j] == 0) {
						m[i+cnt][j] = m[i+cnt-1][j];
						m[i+cnt-1][j] = 0;
						cnt++;
					}
					if(cnt + i < N && m[i+cnt][j] == m[i+cnt-1][j]) {
						if(v[i+cnt][j]) continue;
						v[i+cnt][j] = true;
						m[i+cnt][j] *= 2;
						m[i+cnt-1][j] = 0;
					}
				}
			}
		}else if(dir==2) {
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if(m[i][j] == 0) continue;
					int cnt = 1;
					while(cnt <= j && m[i][j-cnt] == 0) {
						m[i][j-cnt] = m[i][j-cnt+1];
						m[i][j-cnt+1] = 0;
						cnt++;
					}
					if(cnt <= j && m[i][j-cnt] == m[i][j-cnt+1]) {
						if(v[i][j-cnt]) continue;
						v[i][j-cnt] = true;
						m[i][j-cnt] *= 2;
						m[i][j-cnt+1] = 0;
					}
				}
			}
		}else {
			for (int i = 0; i < N; i++) {
				for (int j = N-2; j >= 0; j--) {
					if(m[i][j] == 0) continue;
					int cnt = 1;
					while(cnt + j < N && m[i][j+cnt] == 0) {
						m[i][j+cnt] = m[i][j+cnt-1];
						m[i][j+cnt-1] = 0;
						cnt++;
					}
					if(cnt + j < N && m[i][j+cnt] == m[i][j+cnt-1]) {
						if(v[i][j+cnt]) continue;
						v[i][j+cnt] = true;
						m[i][j+cnt] *= 2;
						m[i][j+cnt-1] = 0;
					}
				}
			}
		}
		return m;
	}
}

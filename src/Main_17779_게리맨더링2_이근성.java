import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17779_게리맨더링2_이근성 {
	static int N,sx,sy,ans;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	static int[] s; 
	static int[][] arr;
	static int[][] map;
	static boolean[][] c,v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		v = new boolean[N][N];
		c = new boolean[N][N];
		map = new int[N][N];
		arr = new int[4][2];
		s = new int[5];
		ans = 1000000;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}// end input
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				sx = i; sy = j;
				dfs(i,j,0);
			}
		}
		System.out.println(ans);
	}
	private static void dfs(int i, int j, int d) {
		if(i == sx && j == sy && v[i][j]) {
			arr[3][0] = i; arr[3][1] = j;
			ans = Math.min(ans, calcSum());
			return;
		}
		if(i < sx) return;
		for (int k = d; k < (d+2>4?4:d+2); k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
			if(k > d) arr[d][0] = i; arr[d][1] = j;
			
			if(v[nx][ny]) continue;
			v[nx][ny] = true;
			dfs(nx,ny,k);
			v[nx][ny] = false;
		}
	}
	private static int calcSum() {
		c = new boolean[N][N];
		Arrays.fill(s, 0);
		int x=arr[3][0],mx = arr[1][0],y=0,my=0;
		// 5번 선거구
		s[0] += map[x][arr[3][1]] + map[mx][arr[1][1]];
		c[x][arr[3][1]] = true;	c[mx][arr[1][1]] = true;
		for (int i = x + 1; i < mx; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(v[i][j]) {
					c[i][j] = true;
					if(cnt++ == 0) y = j;
					else my = j+1;
				}
			}
			for (int j = y; j < my; j++) {
				s[0] += map[i][j];
				c[i][j] = true;
			}
		}
		int max = s[0],min = s[0];
		for (int k = 1; k < 5; k++) {
			switch (k) {
			case 1:
				x = 0; y = 0;
				mx = arr[2][0]; my = arr[3][1]+1;
				break;
			case 2:
				x = 0; y = arr[3][1]+1;
				mx = arr[0][0]+1; my = N;
				break;
			case 3:
				x = arr[2][0]; y = 0;
				mx = N; my = arr[1][1];
				break;
			case 4:
				x = arr[0][0]+1; y = arr[1][1];
				mx = N; my = N;
				break;
			}
			for (int i = x; i < mx; i++) {
				for (int j = y; j < my; j++) {
					if(c[i][j]) continue;
					s[k] += map[i][j];
				}
			}
			max = Math.max(s[k], max);
			min = Math.min(s[k], min);
		}
		
		return max-min;
	}
}

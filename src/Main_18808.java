import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18808 {
	static int N,M,K,R,C;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int ans = 0;
		for (int cnt = 0; cnt < K; cnt++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int[][] input = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) 
					input[i][j] = Integer.parseInt(st.nextToken());
			}
			outer:
			for (int dir = 0; dir < 4; dir++) {
				int[][] color = rotate(input,dir);
				
				int h = color.length;
				int w = color[0].length;
				int s = 0;
				for (int i = 0; i < w; i++) 
					if(color[0][i] > 0) {
						s = i;
						break;
					}
				Queue<int[]> q = new LinkedList<>();
				boolean[][] v = new boolean[h][w];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						int sx = i;
						int sy = s + j;
						if(sx > N-1 || sy > M-1 || map[sx][sy] > 0) continue;
						q.offer(new int[] {sx,sy});
						v[0][s] = true;
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							int x = cur[0];
							int y = cur[1];
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
								if(nx < i || ny < j || nx > h+i-1 || ny > w+j-1 || nx > N-1 || ny > M-1
										|| v[nx-i][ny-j] || color[nx-i][ny-j]==0
										|| map[nx][ny] > 0) continue;
								q.offer(new int[] {nx,ny});
								v[nx-i][ny-j] = true;
							}
						}
						if(check(v,color)) {
							for (int k = 0; k < h; k++) 
								for (int l = 0; l < w; l++) 
									if(v[k][l]) map[i+k][j+l] = 1;
							break outer;
						}else {
							for (int k = 0; k < h; k++) 
								Arrays.fill(v[k], false);
						}
					}
				}
			}
		}
		System.out.println(sum(map));
	}

	private static int sum(int[][] map) {
		int ret = 0;
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++) 
				if(map[i][j]==1) ret++;
		return ret;
	}

	private static boolean check(boolean[][] v, int[][] color) {
		for (int i = 0; i < color.length; i++) 
			for (int j = 0; j < color[0].length; j++) 
				if((v[i][j] && color[i][j]==0)||(!v[i][j] && color[i][j]>0)) return false;
		return true;
	}

	private static int[][] rotate(int[][] input, int i) {
		int[][] ret;
		if(i==0) ret = input;
		else if(i==1) {
			ret = new int[C][R];
			for (int j = 0; j < C; j++) 
				for (int k = 0; k < R; k++) 
					ret[j][k] = input[R-k-1][j];
		}else if(i==2) {
			ret = new int[R][C];
			for (int j = 0; j < R; j++) 
				for (int k = 0; k < C; k++) 
					ret[j][k] = input[R-j-1][C-k-1];
		}else {
			ret = new int[C][R];
			for (int j = 0; j < C; j++) 
				for (int k = 0; k < R; k++) 
					ret[j][k] = input[k][C-j-1];
		}
		return ret;
	}
}

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146 {
	static int N,ans,INF = 1000;
	static int[] dx={-1,1,0,0},dy={0,0,-1,1};
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		masking();
		int ans = 1000000;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				if(checkSea(i,j)){
					v = new boolean[N][N];
					int start = map[i][j];
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i,j,0});
					v[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] c = q.poll();
						int x = c[0];
						int y = c[1];
						int dist = c[2];
						
						if(map[x][y] != start && map[x][y] > 0) {
							ans = Math.min(ans, dist-1);
							break;
						}
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1
									|| v[nx][ny]) continue;
							q.offer(new int[] {nx,ny,dist+1});
							v[nx][ny] = true;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	private static void masking() {
		boolean[][] v = new boolean[N][N];
		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 || v[i][j]) continue;
				Queue<Point> q = new LinkedList<>();
				q.offer(new Point(i,j));
				v[i][j] = true;
				while(!q.isEmpty()) {
					Point p = q.poll();
					map[p.x][p.y] = idx; 
					for (int k = 0; k < 4; k++) {
						int nx = p.x + dx[k];
						int ny = p.y + dy[k];
						
						if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 
								|| v[nx][ny] || map[nx][ny] == 0) continue;
						q.offer(new Point(nx,ny));
						v[nx][ny] = true;
					}
				}
				idx++;
			}
		}
	}
	private static boolean checkSea(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
			if(map[nx][ny] == 0) return true;
		}
		return false;
	}
}

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2933 {
	static int R,C,N;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) 
			map[i] = br.readLine().toCharArray();
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int h = R - Integer.parseInt(st.nextToken());
			int idx = 0;
			if(i%2 == 0) {
				// 막대기 던져
				for (int j = 0; j < C; j++) {
					if(map[h][j] == 'x') {
						idx = j;
						map[h][j] = '.';
						break;
					}
				}
			}else {
				for (int j = C-1; j >= 0; j--) {
					if(map[h][j] == 'x') {
						idx = j;
						map[h][j] = '.';
						break;
					}
				}
			}
			// 떨어져
			down(h,idx);
		}
		// end input
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	private static void down(int h, int idx) {
		Queue<Point> s = new LinkedList<>();
		
		for (int dir = 0; dir < 4; dir++) {
			int nx = h + dx[dir];
			int ny = idx + dy[dir];
			if(nx < 0 || ny < 0 || nx > R-1 || ny > C-1 || map[nx][ny] != 'x')
				continue;
			s.offer(new Point(nx,ny));
		}
		int len = s.size();
		for (int i = 0; i < len; i++) {
			Queue<Point> q = new LinkedList<>();
			boolean[][] v = new boolean[R][C];
			Point p = s.poll();
			v[p.x][p.y] = true;
			q.offer(p);
			int max = 0;
			while(!q.isEmpty()) {
				Point cur = q.poll();
				
				int x = cur.x;
				int y = cur.y;
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					if(nx < 0 || ny < 0 || nx > R-1 || ny > C-1
							||map[nx][ny] != 'x' || v[nx][ny]) continue;
					v[nx][ny] = true;
					q.offer(new Point(nx,ny));
					max = Math.max(nx, max);
				}
			}
			if(max < R-1) 
				realDown(v);
			
		}
	}
	private static void realDown(boolean[][] v) {
		boolean flag = false;
		while(!flag) {
			for (int i = R-2; i >= 0; i--) {
				for (int j = 0; j < C; j++) {
					if(v[i][j]) {
						if(i == R-2) 
							flag = true; 
						if(i < R-2 && map[i+2][j] == 'x' && !v[i+2][j]) flag = true;
						char tmp = map[i][j];
						map[i][j] = map[i+1][j];
						map[i+1][j] = tmp;
						v[i+1][j] = v[i][j];
						v[i][j] = false;
					}
				}
			}
		}
		
	}
}



import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		
		for (int i = 0; i < map.length; i++) 
			map[i] = br.readLine().toCharArray();
		
		Queue<Point> q = new LinkedList<>();
		Queue<Point> q2 = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		boolean[][] v2 = new boolean[N][N];
		int cntA = 0, cntB = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j]) {
					q.offer(new Point(i, j));
					v[i][j] = true;
					cntA++;
					while(!q.isEmpty()) {
						Point p = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							
							if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1
									|| v[nx][ny] || map[nx][ny] != map[p.x][p.y]) continue;
							
							q.offer(new Point(nx, ny));
							v[nx][ny] = true;
						}
					}
				}
				if(!v2[i][j]) {
					q2.offer(new Point(i, j));
					v2[i][j] = true;
					cntB++;
					while(!q2.isEmpty()) {
						Point p = q2.poll();
						for (int k = 0; k < 4; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							
							if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1
									|| v2[nx][ny]) continue;
							if(map[p.x][p.y] == 'B' && map[p.x][p.y] != map[nx][ny]) continue;
							else if(map[p.x][p.y] != 'B' && map[nx][ny] == 'B') continue;
							q2.offer(new Point(nx, ny));
							v2[nx][ny] = true;
						}
					}
				}
			}
		}
		System.out.println(cntA + " " + cntB);
	}
}

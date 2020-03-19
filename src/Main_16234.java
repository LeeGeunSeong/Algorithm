import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {
	static int N,L,R,ans;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		boolean f = false;
		while(true) {
			f = true;
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				outer:
				for (int j = 0; j < N; j++) {
					if(v[i][j]) continue;
					
					Queue<Point> q = new LinkedList<>();
					List<Point> list = new ArrayList<>();
					q.offer(new Point(i,j));
					v[i][j] = true;
					list.add(new Point(i,j));
					int sum = map[i][j];
					while(!q.isEmpty()) {
						Point p = q.poll();
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = p.x + dx[dir];
							int ny = p.y + dy[dir];
							if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1
									||v[nx][ny]) continue;
							
							int diff = Math.abs(map[p.x][p.y] - map[nx][ny]);
							
							if(diff >= L && diff <= R) {
								q.add(new Point(nx, ny));
								list.add(new Point(nx,ny));
								v[nx][ny] = true;
								sum += map[nx][ny];
							}
						}
					}
					int change = sum/list.size();
					if(list.size() == 1) continue outer;
					for (int k = 0; k < list.size(); k++) {
						map[list.get(k).x][list.get(k).y] = change;
						f = false;
					}
				}
			}
			if(f) break;
			ans++;
		}
		
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.Messaging.SyncScopeHelper;

public class Main_2636_치즈_이근성 {
	static int[][] map;
	static int R,C,ans,befCh;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int[][] newMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				newMap[i][j] = map[i][j];
			}
		}// end input
		
		ans = 0;
		Queue<Node> queue = new LinkedList<>();
		while(!check()) {
			ans++;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if((i == 0 || j == 0 || i == R-1 || j == C-1)
							&&(map[i][j] == 0)) {
						queue.offer(new Node(i,j));
						map[i][j] = -1;
						while(!queue.isEmpty()) {
							Node cur = queue.poll();
							for (int dir = 0; dir < dx.length; dir++) {
								int nx = cur.x + dx[dir];
								int ny = cur.y + dy[dir];
								
								if(nx < 0 || ny < 0 || nx >= R || ny >= C
										|| map[nx][ny] != 0) continue;
								
								map[nx][ny] = -1;
								queue.offer(new Node(nx, ny));
							}
						}
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == -1) {
						for (int dir = 0; dir < dx.length; dir++) {
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							
							if(nx < 0 || ny < 0 || nx >= R || ny >= C
									|| map[nx][ny] == -1) continue;
							newMap[nx][ny] = -1;
						}
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = newMap[i][j];
					if(map[i][j] == -1) map[i][j] = 0;
				}
			}
		}
		System.out.println(ans);
		System.out.println(befCh);
	}// end main
	private static boolean check() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 1) sum++;
			}
		}
		if(sum > 0) {
			befCh = sum;
			return false;
		}else 
			return true;
	}
}

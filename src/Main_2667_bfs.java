import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667_bfs {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Integer> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		// end input
		// bfs
		bfs(N,map);
	}
	private static void bfs(int N, int[][] map) {
		// init
		boolean[][] visited = new boolean[N][N];
		ans = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 || visited[i][j]) continue;
				
				//bfs
				Queue<Point> q = new LinkedList<>();
				q.offer(new Point(i, j));
				visited[i][j] = true;
				int cnt = 0;
				while(!q.isEmpty()) {
					Point cur = q.poll();
					cnt++;
					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.x + dx[dir];
						int ny = cur.y + dy[dir];
						
						if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1
								|| visited[nx][ny] 
										|| map[nx][ny] == 0) continue;
						
						q.offer(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
				ans.add(cnt);
			}
		}
		System.out.println("--------------------------------------");
		System.out.println("BFS 결과");
		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) 
			System.out.println(ans.get(i));
		System.out.println("--------------------------------------");
		
	}
}

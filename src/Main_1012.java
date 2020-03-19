import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			boolean[][] v = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					Queue<Point> q = new LinkedList<>();
					if(map[i][j] == 1 && !v[i][j]) {
						q.add(new Point(i,j));
						v[i][j] = true;
						ans++;
						while(!q.isEmpty()) {
							Point p = q.poll();
							
							for (int l = 0; l < 4; l++) {
								int nx = p.x + dx[l];
								int ny = p.y + dy[l];
								
								if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1
										|| v[nx][ny] || map[nx][ny] == 0) continue;
								q.add(new Point(nx,ny));
								v[nx][ny] = true;
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
}

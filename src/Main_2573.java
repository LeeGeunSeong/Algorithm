import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573 {
	static int N,M,ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] nMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
				nMap[i][j] = map[i][j];
			}
		}
		ans = -1;
		int cnt = 0;
		while(true) {
			cnt++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0) continue;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1 
								|| nMap[nx][ny]==0) continue;
						nMap[nx][ny]--;
					}
				}
			}
			for (int j = 0; j < N; j++) 
				for (int k = 0; k < M; k++) 
					map[j][k] = nMap[j][k];
			if(check(map)) break;
		}
		System.out.println(ans==0?ans:cnt);
	}
	private static boolean check(int[][] map) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		outer:
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) 
				if(map[i][j] > 0) {
					q.offer(new Point(i,j));
					v[i][j] = true;
					break outer;
				}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1
						|| v[nx][ny] || map[nx][ny] == 0) continue;
				q.offer(new Point(nx,ny));
				v[nx][ny] = true;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++) { 
				if(map[i][j] > 0 && !v[i][j]) return true;
				sum += map[i][j];
			}
		
		if(sum == 0) { 
			ans = 0;
			return true;
		}
		return false;
	}
}

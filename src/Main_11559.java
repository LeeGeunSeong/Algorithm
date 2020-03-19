import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[12][6];
		
		for (int i = 0; i < 12; i++) 
			map[i] = br.readLine().toCharArray();
		
		int ans = 0;
		while(true) {
			int count = 0; 
			
			boolean[][] v = new boolean[12][6];
			boolean[][] explode = new boolean[12][6];
			
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(map[i][j] == '.' || v[i][j]) continue;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i,j});
					v[i][j] = true;
					int num = 1;
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6
									|| v[nx][ny] || map[x][y] != map[nx][ny]) continue;
							cnt++;
							num++;
							q.add(new int[] {nx,ny});
							count = Math.max(count, num);
							v[nx][ny] = true;
						}
						if(num >= 4 && cnt == 0) {
							Queue<int[]> exp = new LinkedList<>();
							exp.add(new int[] {x,y});
							explode[x][y] = true;
							while(!exp.isEmpty()) {
								int[] c = exp.poll();
								for (int k = 0; k < 4; k++) {
									int tx = c[0] + dx[k];
									int ty = c[1] + dy[k];

									if(tx < 0 || ty < 0 || tx >= 12 || ty >= 6
											|| explode[tx][ty] || map[c[0]][c[1]] != map[tx][ty]) continue;
									
									exp.add(new int[] {tx,ty});
									explode[tx][ty] = true;
								}
							}
						}
					}
				}
			}
			// 폭발
			for (int i = 0; i < 12; i++) 
				for (int j = 0; j < 6; j++) 
					if(explode[i][j]) map[i][j] = '.';
			// 내리기
			for (int i = 10; i >= 0; i--) { 
				for (int j = 0; j < 6; j++) {
					if(map[i][j] != '.') {
						int cnt = 1;
						while(i+cnt < 12 && map[i+cnt][j] == '.') {
							map[i+cnt][j] = map[i+cnt-1][j];
							map[i+cnt-1][j] = '.';
							cnt++;
						}
					}
				}
			}
			if(count < 4) break;
			ans++;
		}
		System.out.println(ans);
	}
}

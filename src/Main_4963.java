import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963 {
	static int[] dx = {-1,-1,-1,1,1,1,0,0};
	static int[] dy = {-1,0,1,-1,0,1,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			int[][] map = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 0) continue;
					
					Queue<int[]> q = new LinkedList<int[]>();
					
					q.offer(new int[] {i,j});
					map[i][j] = 0;
					ans++;
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];
						for (int k = 0; k < 8; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(nx < 0 || nx > h-1 || ny < 0 || ny > w-1
									|| map[nx][ny] == 0) continue;
							q.offer(new int[] {nx,ny});
							map[nx][ny] = 0;
						}
					}
				}
			}
			
			bw.append(ans + "\n");
		}
		bw.flush();
		bw.close();
	}
}

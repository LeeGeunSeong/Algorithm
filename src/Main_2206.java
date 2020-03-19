import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) 
				map[i][j] = str.charAt(j) - '0';
		}
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] v = new boolean[N][M][2];
		
		q.offer(new int[] {0,0,1,0});
		v[0][0][0] = true;
		v[0][0][1] = true;
		int ans = -1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int val = cur[2];
			int flag = cur[3];
			if(x == N-1 && y == M-1) {
				ans = val;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1 ||
						v[nx][ny][flag]) continue;
				if(flag == 0) {
					if(map[nx][ny] > 0) {
						q.offer(new int[] {nx,ny,val+1,1});
						v[nx][ny][1] = true;
					}else {
						q.offer(new int[] {nx,ny,val+1,flag});
						v[nx][ny][flag] = true;
					}
				}else {
					if(map[nx][ny] > 0) continue;
					q.offer(new int[] {nx,ny,val+1,flag});
					v[nx][ny][flag] = true;
				}
			}
		}
		System.out.println(ans);
	}
}

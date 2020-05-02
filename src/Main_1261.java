import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) 
				map[i][j] = tmp[j]-'0'; 
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		int[][] v = new int[N][M];
		for (int i = 0; i < v.length; i++) 
			Arrays.fill(v[i], 1000000000);
		q.offer(new int[] {0,0,0});
		v[0][0] = 0;
		int ans = 100000000;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			if(x==N-1 && y==M-1) {
				ans = cur[2];
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <0 || nx > N-1 || ny < 0 || ny >M-1) continue;
				if(v[x][y] + map[nx][ny] < v[nx][ny]) {
					v[nx][ny] = v[x][y] + map[nx][ny];
					q.offer(new int[] {nx,ny,v[nx][ny]});
				}
			}
		}
		System.out.println(ans);
	}
}

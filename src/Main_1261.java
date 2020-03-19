import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		boolean[][] v = new boolean[N][M];
		q.offer(new int[] {0,0,0});
		v[0][0] = true;
		int ans = 100000000;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int val = cur[2];
			if(x==N-1 && y==N-1) {
				ans = val;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <0 || nx > N-1 || ny < 0 || ny >M-1
						|| v[nx][ny]) continue;
				if(map[nx][ny]==0) q.offer(new int[] {nx,ny,val});
				else q.offer(new int[] {nx,ny,val+1});
				v[nx][ny] = true;
			}
		}
		System.out.println(ans);
	}
}

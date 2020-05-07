import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {
	static int[] dx = {-2,-2,-1,-1,1,1,2,2};
	static int[] dy = {-1,1,-2,2,-2,2,-1,1};
	static int sx,sy,ex,ey,ans,I;
	static int[][] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		while(T-- > 0) {
			I = Integer.parseInt(br.readLine());
			count = new int[I][I];
			for (int i = 0; i < I; i++) {
				Arrays.fill(count[i], 10000000);
			}
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			solve(sx,sy);
			System.out.println(ans);
		}
	}
	private static void solve(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[I][I];
		q.offer(new int[] {x,y,0});
		v[x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==ex && cur[1]==ey) {
				ans = cur[2];
				return ;
			}
			for (int i = 0; i < 8; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx > I-1 || ny < 0 || ny > I-1
						|| v[nx][ny]) continue;
				q.offer(new int[] {nx,ny,cur[2]+1});
				v[nx][ny] = true;
			}
		}
	}
}

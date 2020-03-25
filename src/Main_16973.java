import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973 {
	static int N,M,H,W,sx,sy,ex,ey;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken())-1;
		sy = Integer.parseInt(st.nextToken())-1;
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		q.offer(new int[] {sx,sy,0});
		v[sx][sy] = true;
		int ans = -1;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			int val = c[2];
			
			if(x==ex && y==ey) {
				ans = val;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx+H>N || ny+W>M
						|| v[nx][ny] || checkWall(nx,ny)) continue;
				
				q.offer(new int[] {nx,ny,val+1});
				v[nx][ny] = true;
			}
		}
		System.out.println(ans);
	}
	private static boolean checkWall(int nx, int ny) {
		for (int i = nx; i < nx+H; i++) 
			for (int j = ny; j < ny+W; j++) 
				if(map[i][j] == 1) return true;
		return false;
	}
}

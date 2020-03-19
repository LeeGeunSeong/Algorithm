import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
	static int N,M,H;
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int[][][] map = new int[H][N][M];
		int ans = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] v = new boolean[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) { 
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) {
						q.add(new int[]{i,j,k,0});
						v[i][j][k] = true;
					}
				}
			}
		}
		//1 익토 0 익않토 -1 없토
		if(check(map)) System.out.println(0);
		else{
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				ans = Math.max(ans, cur[3]);
				for (int i = 0; i < 6; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];
					int nz = cur[2] + dz[i];
					
					if(nx < 0 || ny < 0 || nz < 0 || nx > H-1 || ny > N-1 || nz > M-1
							|| v[nx][ny][nz] || map[nx][ny][nz] != 0) continue;
					q.add(new int[] {nx,ny,nz,cur[3]+1});
					map[nx][ny][nz] = 1;
					v[nx][ny][nz] = true;
				}
			}
			
			if(check(map)) System.out.println(ans);
			else System.out.println(-1);
		}
	}
	private static boolean check(int[][][] map) {
		for (int i = 0; i < H; i++) 
			for (int j = 0; j < N; j++) 
				for (int k = 0; k < M; k++) 
					if(map[i][j][k] == 0) return false;
		return true;
	}
}

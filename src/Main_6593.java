import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593 {
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) break;
			char[][][] map = new char[L][R][C];
			
			Queue<int[]> q = new LinkedList<>();
			boolean[][][] v = new boolean[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) 
					map[i][j] = br.readLine().toCharArray();
				br.readLine();
			}
			
			for (int i = 0; i < L; i++) 
				for (int j = 0; j < R; j++) 
					for (int k = 0; k < C; k++) { 
						if(map[i][j][k] == 'S') {
							q.add(new int[] {i,j,k,0});
							v[i][j][k] = true;
						}
					}
			boolean f = false;
			int ans = 0;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int z = cur[2];
				int sec = cur[3];
				if(map[x][y][z] == 'E') {
					f = true;
					ans = sec;
					break;
				}
				for (int i = 0; i < 6; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int nz = z + dz[i];
					
					if(nx < 0 || ny < 0 || nz < 0 || nx >= L || ny >= R || nz >= C
							|| v[nx][ny][nz] || map[nx][ny][nz] == '#') continue;
					
					q.add(new int[] {nx,ny,nz,sec+1});
					v[nx][ny][nz] = true;
				}
			}
			if(f) System.out.println("Escaped in " + ans + " minute(s).");
			else System.out.println("Trapped!");
			
		}
	}
}

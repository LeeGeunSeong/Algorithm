import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_2151 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] home = new char[N][N];
		
		for (int i = 0; i < N; i++) 
			home[i] = br.readLine().toCharArray();
		
		int[][] door = new int[2][2];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(home[i][j] == '#') {
					door[idx][0] = i; door[idx++][1] = j;
				}
			}
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		int[][][] v = new int[N][N][4];
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				for (int k = 0; k < 4; k++) 
					v[i][j][k] = 100000000;
					
		for (int i = 0; i < 4; i++) {
			int nx = door[0][0] + dx[i];
			int ny = door[0][1] + dy[i];
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || home[nx][ny] =='*') continue;
			q.offer(new int[] {nx,ny,0,i});
			v[nx][ny][i] = 0;
		}
		int ans = 0;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int x = c[0];
			int y = c[1];
			int val = c[2];
			int dir = c[3];
			if(x==door[1][0] && y==door[1][1]) {
				ans = val;
				break;
			}
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx >= 0 && ny >= 0 && nx <= N-1 && ny <= N-1 && val < v[nx][ny][dir] && home[nx][ny] != '*') {
				q.offer(new int[] {nx,ny,val,dir});
				v[nx][ny][dir] = val;
			}
			if(home[x][y] == '!') {
				int d = (dir+1)%4;
				nx = x + dx[d];
				ny = y + dy[d];
				if(nx >= 0 && ny >= 0 && nx <= N-1 && ny <= N-1 && val+1 < v[nx][ny][d] && home[nx][ny] != '*') {
					q.offer(new int[] {nx,ny,val+1,d});
					v[nx][ny][d] = val+1;
				}
				d = dir==0?3:dir-1;
				nx = x + dx[d];
				ny = y + dy[d];
				if(nx >= 0 && ny >= 0 && nx <= N-1 && ny <= N-1 && val+1 < v[nx][ny][d] && home[nx][ny] != '*') {
					q.offer(new int[] {nx,ny,val+1,d});
					v[nx][ny][d] = val+1;
				}
			}
		}
		System.out.println(ans);
	}
}

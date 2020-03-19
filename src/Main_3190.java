import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190 {
	static int N,K,L,idx,ans;
	static int[][] map,len;
	static int[] time;
	static char[] dir;
	static class baam{
		int x,y,tx,ty;

		public baam(int x, int y, int tx, int ty) {
			super();
			this.x = x;
			this.y = y;
			this.tx = tx;
			this.ty = ty;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		len = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new  StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			map[x][y] = 1;
		}
		L = Integer.parseInt(br.readLine());
		
		time = new int[L];
		dir = new char[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			dir[i] = st.nextToken().charAt(0);
		}
		System.out.println(move(0,0));
		
	}
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0}; // 동 남 서 북
	private static int move(int x, int y) {
		int sec = 0;
		int dir = 0;
		int length = 0;
		Queue<baam> q = new LinkedList<>();
		q.offer(new baam(x, y, x, y));
		len[x][y] = ++length;
		
		while(!q.isEmpty()) {
			baam cur = q.poll();
			dir = chnDir(dir,sec++);
			int nx = cur.x + dx[dir];
			int ny = cur.y + dy[dir];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N
					|| len[nx][ny] > 0) return sec;
			if(map[nx][ny] == 1) {
				len[nx][ny] = ++length;
				q.offer(new baam(nx, ny, cur.tx, cur.ty));
				map[nx][ny] = 0;
			}else {
				for (int i = 0; i < 4; i++) {
					int ntx = cur.tx + dx[i];
					int nty = cur.ty + dy[i];
					
					if(ntx < 0 || nty < 0 || ntx >= N || nty >= N) continue;
					if(len[ntx][nty] - len[cur.tx][cur.ty] == 1) {
						for (int j = 0; j < N; j++) 
							for (int k = 0; k < N; k++) 
								if(len[j][k] > 0) len[j][k]--;
						
						len[nx][ny] = length;
						q.offer(new baam(nx, ny, ntx, nty));
						break;
					}else if(length == 1) {
						len[nx][ny] = 1;
						len[cur.tx][cur.ty] = 0; 
						q.offer(new baam(nx, ny, nx, ny));
						break;
					}
				}
			}
		}
		return sec;
	}
	private static int chnDir(int d, int sec) {
		if(idx < L && time[idx] == sec) {
			if(dir[idx++] == 'L') 
				d = d-1<0?3:d-1;
			else 
				d = (d+1)%4;
		}
		return d;
	}
}

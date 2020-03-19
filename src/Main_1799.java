import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1799 {
	static int N,bans,wans;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		v = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		bdfs(0,0,0);
		v = new boolean[N][N];
		wdfs(0,1,0);
		System.out.println(bans+wans);
	}
	private static void bdfs(int x, int y,int cnt) {
		if(y >= N) {
			x++;
			y=(x%2==0)?0:1;
		}
		if(x >= N) {
			bans = Math.max(bans, cnt);
			return;
		}
		if(!check(x,y)) {
			v[x][y] = true;
			bdfs(x,y+2,cnt+1);
			v[x][y] = false;
		}
		bdfs(x,y+2,cnt);
	}
	private static void wdfs(int x, int y,int cnt) {
		if(y >= N) {
			x++;
			y=(x%2==0)?1:0;
		}
		if(x >= N) {
			wans = Math.max(wans, cnt);
			return;
		}
		if(!check(x,y)) {
			v[x][y] = true;
			wdfs(x,y+2,cnt+1);
			v[x][y] = false;
		}
		wdfs(x,y+2,cnt);
	}
	private static boolean check(int x, int y) {
		if(map[x][y] == 0) return true;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < N; j++) {
				if(x==i && y==j) continue;
				if(Math.abs(x-i) == Math.abs(y-j) && v[i][j]) return true;
			}
		}
		return false;
	}
}

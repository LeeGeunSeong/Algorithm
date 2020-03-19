import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683 {
	static int N,M,max,ans;
	static int[][] map;
	static int[] dir;
	static class cctv{
		int x,y,val;

		public cctv(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	static List<cctv> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = 100;
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					list.add(new cctv(i, j, map[i][j]));
					max++;
				}
			}
		}
		dir = new int[4];
		Arrays.fill(dir, -1);
		dfs(0);
		
		System.out.println(ans);
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static void dfs(int cnt) {
		if(cnt == max) {
			ans = Math.min(ans, calc());
			return;
		}
		int[][] saveMap = new int[N][M];
		copyMap(saveMap, map);
		cctv cur = list.get(cnt);
		int x = cur.x, y = cur.y;
		switch (cur.val) {
		case 1:
			for (int i = 0; i < 4; i++) {
				move(x,y,i);
				dfs(cnt+1);
				copyMap(map,saveMap);
			}
			break;
		case 2:
			int[] s = {0,2};
			int[] e = {2,4};
			for (int j = 0; j < 2; j++) {
				for (int i = s[j]; i < e[j]; i++) 
					move(x,y,i);
				dfs(cnt+1);
				copyMap(map,saveMap);
			}
			break;
		case 3:
			move(x,y,0);
			move(x,y,2);
			dfs(cnt+1);
			copyMap(map,saveMap);
			
			move(x,y,1);
			move(x,y,3);
			dfs(cnt+1);
			copyMap(map,saveMap);
			
			move(x,y,1);
			move(x,y,2);
			dfs(cnt+1);
			copyMap(map,saveMap);
			
			move(x,y,0);
			move(x,y,3);
			dfs(cnt+1);
			copyMap(map,saveMap);			
			break;
		case 4:
			move(x,y,0);
			move(x,y,1);
			move(x,y,3);
			dfs(cnt+1);
			copyMap(map,saveMap);
			
			move(x,y,0);
			move(x,y,2);
			move(x,y,3);
			dfs(cnt+1);
			copyMap(map,saveMap);
			
			move(x,y,1);
			move(x,y,2);
			move(x,y,3);
			dfs(cnt+1);
			copyMap(map,saveMap);
			
			move(x,y,0);
			move(x,y,1);
			move(x,y,2);
			dfs(cnt+1);
			copyMap(map,saveMap);
			break;
		case 5:
			for (int i = 0; i < 4; i++)
				move(x,y,i);
			dfs(cnt+1);
			copyMap(map,saveMap);
			break;

		default:
			break;
		}
	}

	private static void move(int x, int y,int dir) {
		while(true) {
			x += dx[dir];
			y += dy[dir];
			if(x < 0 || y < 0 || x > N-1 || y > M-1 
					|| map[x][y] == 6) break;
			if(map[x][y] == 0) map[x][y] = -1;
		}
	}

	private static void copyMap(int[][] m1, int[][] m2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) 
				m1[i][j] = m2[i][j];
		}
	}
	
	private static int calc() {
		int ret = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) 
				if(map[i][j] == 0) ret++;
		}
		return ret;
	}
}

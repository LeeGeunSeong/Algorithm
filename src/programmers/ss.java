//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class ss {
//	static int N,W,H,ans;
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0,-1,1};
//	static int[][] map;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int T = Integer.parseInt(br.readLine());
//		
//		for (int tc = 1; tc <= T; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			N = Integer.parseInt(st.nextToken());
//			W = Integer.parseInt(st.nextToken());
//			H = Integer.parseInt(st.nextToken());
//			map = new int[H][W];
//			ans = Integer.MAX_VALUE;
//			for (int i = 0; i < H; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < W; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}// end input
//			dfs(map,0);
//			System.out.println("#"+tc+" "+ans);
//		}//end tc
//		
//	}//end main
//	private static void dfs(int[][] newMap, int cnt) {
//		if(cnt == N || calc(newMap) == 0) {
//			ans = Math.min(ans, calc(newMap));
//			return;
//		}
//		outer:
//		for (int i = 0; i < W; i++) {
//			int count = -1;
//			int[][] tmp = new int[H][W];
//			for (int j = 0; j < H; j++) 
//				for (int k = 0; k < W; k++) 
//					tmp[j][k] = newMap[j][k];
//			while(tmp[++count][i] == 0) {
//				if(count == H-1) continue outer;
//			}
//			dropGuseul(tmp,count,i);
//			dropByeogdol(tmp);
//			dfs(tmp,cnt+1);
//		}
//	}
//	private static void dropByeogdol(int[][] tmp) {
//		for (int i = H-2; i >= 0; i--) {
//			for (int j = 0; j < W; j++) {
//				if(tmp[i][j] == 0) continue;
//				int nx = i;
//				while(true) {
//					if(++nx > H-1 || tmp[nx][j] > 0) break;
//				}
//				tmp[--nx][j] = tmp[i][j];
//				if(nx != i)	tmp[i][j] = 0;
//			}
//		}
//	}
//	private static void dropGuseul(int[][] tmp, int x, int y) {
//		int dist = tmp[x][y]-1;
//		tmp[x][y] = 0;
//		for (int i = 0; i < dx.length; i++) {
//			if(dist == 0) {
//				tmp[x][y] = 0;
//				return;
//			}
//			int count = 0;
//			int nx = x, ny = y;
//			while(count++ < dist) {
//				nx += dx[i]; ny += dy[i];
//				if(nx < 0 || ny < 0 || nx > H-1 || ny > W-1
//						|| tmp[nx][ny] == 0) continue;
//				if(tmp[nx][ny] >1) dropGuseul(tmp,nx,ny);
//				else tmp[nx][ny] = 0;
//			}
//		}
//	}
//	private static int calc(int[][] tmp) {
//		int ret = 0;
//		for (int i = 0; i < H; i++) 
//			for (int j = 0; j < W; j++) 
//				if(tmp[i][j] > 0) ret++; 
//		return ret;
//	}
//}

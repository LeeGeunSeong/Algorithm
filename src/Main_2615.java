import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615 {
	static int[] dx = {1,0,1,-1};
	static int[] dy = {0,1,1,1};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[19][19];
		int len = 19;
		for (int i = 0; i < len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(map[i][j] == 0) continue;
				
				if(check(i,j)) {
					System.out.println(map[i][j]);
					System.out.println((i+1) + " " + (j+1));
					return;
				}
			}
		}
		System.out.println(0);
	}
	private static boolean check(int x, int y) {
		for (int dir = 0; dir < dx.length; dir++) {
			int tx = x, ty = y;
			int cnt = 0;
			while(map[tx][ty] == map[x][y]) {
                tx += dx[dir];
                ty += dy[dir];
                cnt++;
                if(tx < 0 || tx > 18 || ty < 0 || ty > 18) break;
            }
			if(cnt==5) {
				if(x >= dx[dir] && y >= dy[dir] 
						&& map[x-dx[dir]][y-dy[dir]] == map[x][y]) return false;
				return true;
			}
		}
		return false;
	}
	
}

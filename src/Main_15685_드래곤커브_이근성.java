import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브_이근성 {
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dc = new int[N][4];
		StringTokenizer st;
		int[][] map = new int[101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dc[i][1] = Integer.parseInt(st.nextToken()); 
			dc[i][0] = Integer.parseInt(st.nextToken()); 
			dc[i][2] = Integer.parseInt(st.nextToken()); 
			dc[i][3] = Integer.parseInt(st.nextToken()); 
		}// end input
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int[] tmp = dc[i];
			int x = tmp[0], y = tmp[1], d = tmp[2], g = tmp[3];
			map[x][y] = 1;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0 || ny < 0 || nx > 100 || ny > 100) break;
			map[nx][ny] = 1;
			list.add(d);
			outer:
			for (int j = 1; j <= g; j++) {
				int len = list.size();
				for (int k = len-1; k >= 0; k--) {
					int dir = list.get(k);
					dir = (dir+1)%4;
					nx += dx[dir];
					ny += dy[dir];
					if(nx < 0 || ny < 0 || nx > 100 || ny > 100) break outer;
					map[nx][ny] = 1;
					list.add(dir);
				}
			}
			list.clear();
		}
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 
						&& map[i][j+1] == 1 && map[i+1][j+1] == 1) ans++; 
			}
		}
		System.out.println(ans);
		
		
	}
}

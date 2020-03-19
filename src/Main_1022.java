import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1022 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[r2-r1+1][c2-c1+1];
		
		int x = 0, y = 0, idx = 1, cnt = 0, dir = 3, num = 1;
		while(map[0][0] == 0 || map[r2-r1][0] == 0 || map[0][c2-c1] == 0 || map[r2-r1][c2-c1] == 0) {
			if(x >= r1 && x <=r2 && y >= c1 && y <= c2) {
				map[x-r1][y-c1] = idx;
			}
			idx++;
			cnt++;
			x += dx[dir];
			y += dy[dir];
			
			if(cnt == num) {
				cnt = 0;
				if(dir == 0 || dir == 2) num++;
				dir = (dir+1)%4;
			}
		}
		
		int m = 0;
		for (int i = 0; i <= r2-r1; i++) {
			for (int j = 0; j <= c2-c1; j++) {
				m = Math.max(m, map[i][j]);
			}
		}
		int digit = 1;
		while(m >= 10) {
			m /= 10;
			digit++;
		}
		for (int i = 0; i <= r2-r1; i++) {
			for (int j = 0; j <= c2-c1; j++) {
				int dig = 1;
				int tmp = map[i][j];
				while(tmp >= 10) {
					tmp /= 10;
					dig++;
				}
				while(dig++ < digit) sb.append(" ");
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

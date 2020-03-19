import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992 {
	static String ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		ans = "";
		divide(0,N-1,0,N-1);
		
		System.out.println(ans);
	}
	private static void divide(int sx, int ex, int sy, int ey) {
		int check = check(sx,ex,sy,ey);
		if(check < 0) {
			if(sx < ex && sy < ey) {
				ans+= "(";
				int mx = (sx + ex)/2;
				int my = (sy + ey)/2;
				divide(sx, mx, sy, my);
				divide(sx, mx, my+1, ey);
				divide(mx+1, ex, sy, my);
				divide(mx+1, ex, my+1, ey);
				ans += ")";
			}
		}else {
			ans += check;
		}
	}
	private static int check(int sx, int ex, int sy, int ey) {
		int check = map[sx][sy];
		for (int i = sx; i <= ex; i++) {
			for (int j = sy; j <= ey; j++) {
				if(map[i][j] != check) return -1;
			}
		}
		return check;
	}
}

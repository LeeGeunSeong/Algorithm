import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
	static int N;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
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
		int minus = 0,zero = 0, plus = 0;
		int num = 1;
		if(check(0,N,0,N)) {
			switch (map[0][0]) {
			case -1: minus = 1;
			break;
			case 0: zero = 1;
			break;
			case 1: plus = 1;
			break;
			}
		}else {
			while(N>1) {
				N /= 3;
				num *= 3;
				for (int i = 0; i < num; i++) {
					for (int j = 0; j < num; j++) {
						int sx = i*N, ex = (i+1)*N;
						int sy = j*N, ey = (j+1)*N;
						if(check(sx,ex,sy,ey)) {
							if(v[sx][sy]) continue;
							for (int k = sx; k < ex; k++) {
								for (int k2 = sy; k2 < ey; k2++) {
									v[k][k2] = true;
								}
							}
							v[sx][sy] = true;
							switch (map[sx][sy]) {
							case -1: minus++;
								break;
							case 0: zero++;
								break;
							case 1: plus++;
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
	private static boolean check(int sx, int ex, int sy, int ey) {
		int check = map[sx][sy];
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				if(map[i][j] != check) return false;
			}
		}
		return true;
	}
}

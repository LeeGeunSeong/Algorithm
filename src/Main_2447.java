import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2447 {
	static int N;
	static char[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		map = new char[N][N];
		divide(0,N-1,0,N-1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
				sb.append(map[i][j]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void divide(int sx, int ex, int sy, int ey) {
		if(sx<ex && sy< ey) {
			int mx1 = (2*sx+ex)/3;
			int mx2 = (sx+2*ex)/3;
			int my1 = (2*sy+ey)/3;
			int my2 = (sy+2*ey)/3;
			divide(sx,mx1,sy,my1);
			divide(sx,mx1,my1+1,my2);
			divide(sx,mx1,my2+1,ey);
			divide(mx1+1, mx2,sy,my1);
			for (int i = mx1+1; i <= mx2; i++) 
				for (int j = my1+1; j <= my2; j++) 
					map[i][j] = ' ';
			divide(mx1+1, mx2,my2+1,ey);
			divide(mx2+1,ex,sy,my1);
			divide(mx2+1,ex,my1+1,my2);
			divide(mx2+1,ex,my2+1,ey);
		}else {
			map[sx][sy] = '*';
		}
	}
}

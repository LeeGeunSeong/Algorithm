import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2567_색종이2_이근성 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int ans = 0;
		int[][] map = new int[101][101];
		int xmin=Integer.MAX_VALUE, ymin=Integer.MAX_VALUE;
		int xmax=0,ymax=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xmax = Math.max(xmax, x);
			ymax = Math.max(ymax, y);
			xmin = Math.min(xmin, x);
			ymin = Math.min(ymin, y);
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if(map[j][k] == 0) {
						map[j][k] = 1;
					}
				}
			}
		}
		for (int i = xmin; i < xmax+10; i++) {
			for (int j = ymin; j < ymax+10; j++) {
				if(map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						if(map[i+dx[k]][j+dy[k]] == 0) {
							ans++;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}//end main
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111 {
	static int N,M,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)  
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int ans = Integer.MAX_VALUE, h = 0;
		for (int c = 0; c <= 256; c++) {
			int block = B, sec = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] < c) {
						int tmp = c - map[i][j];
						sec += tmp;
						block -= tmp;
					}else if(map[i][j] > c) {
						int tmp = map[i][j] - c;
						sec += 2*tmp;
						block += tmp;
					}
				}
			}
			if(block >= 0 && ans >= sec) {
				ans = sec;
				h = c;
			}
		}
		System.out.println(ans + " " + h);
	}

}

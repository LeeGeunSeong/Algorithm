import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2563_색종이_이근성 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int ans = 0;
		int[][] map = new int[101][101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if(map[j][k] == 0) {
						map[j][k] = 1;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}//end main
}
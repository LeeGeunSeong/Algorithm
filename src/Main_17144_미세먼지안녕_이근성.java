import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕_이근성 {
	static int N, C, R;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		int T = Integer.parseInt(st.nextToken()); // T초 후 종료

		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		int[][] newMap = new int[R][C];
		while (T-- > 0) {
			for (int i = 0; i < R; i++) 
				Arrays.fill(newMap[i], 0);
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] < 5)
						continue;
					// 미세먼지 확산
					int dust = map[i][j] / 5;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || ny < 0 || nx > R - 1 || ny > C - 1 || map[nx][ny] == -1)
							continue;
						newMap[nx][ny] += dust;
						map[i][j] -= dust;
					}
				}
			}
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++)
					map[i][j] += newMap[i][j];
			// 공기청정기 작동
			int cnt = 0;
			for (int i = 0; i < R; i++) {
				if (map[i][0] == -1) {
					int tmp = map[0][1];
					int tmp2 = map[R - 1][1];
					int tmp3 = map[i][C - 2];
					for (int j = C - 2; j > 1; j--) {
						map[i][j] = map[i][j - 1];
						map[i][j - 1] = 0;
					}
					if (cnt == 0) {
						for (int j = 1; j < C - 1; j++) {
							map[0][j] = map[0][j + 1];
							map[0][j + 1] = 0;
						}
						for (int j = 0; j < i; j++) {
							map[j][C - 1] = map[j + 1][C - 1];
							map[j + 1][C - 1] = 0;
						}
						for (int j = i - 1; j > 0; j--) {
							map[j][0] = map[j - 1][0];
							map[j - 1][0] = 0;
						}
						map[0][0] = tmp;
						cnt++;
					} else {
						for (int j = 1; j < C - 1; j++) {
							map[R - 1][j] = map[R - 1][j + 1];
							map[R - 1][j + 1] = 0;
						}
						for (int j = R - 1; j > i; j--) {
							map[j][C - 1] = map[j - 1][C - 1];
							map[j - 1][C - 1] = 0;
						}
						for (int j = i + 1; j < R - 1; j++) {
							map[j][0] = map[j + 1][0];
							map[j + 1][0] = 0;
						}
						map[R - 1][0] = tmp2;
					}
					map[i][C - 1] = tmp3;
				}
			}
		}

		System.out.println(printSum(map));
	}// end main

	private static int printSum(int[][] map) {
		int sum = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] > 0)
					sum += map[i][j];
		return sum;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16954_DFS {

	static int[] dx = { 0, -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 0, 1, -1, 1, -1, 1, -1 };
	static char[][][] map;
	static int N, ans;
	static int[] min;
	static boolean flag;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 8;
		map = new char[N][N][N];
		char[][] input = new char[N][N];
		for (int i = 0; i < N; i++)
			input[i] = br.readLine().toCharArray();
		min = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (j - i >= 0) {
						map[i][j][k] = input[j - i][k];
					} else {
						map[i][j][k] = '.';
					}
				}
			}
		} // i초 이동한 후의 map[j][k]배열

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				for (int k = 0; k < N; k++) {
					if (map[i][j][k] == '#')
						min[i] = j; // 가장 작은 x인덱스를 이용해서 가지치기
				}
			}
		}
		/*
		 * .....
		 * .c...
		 * ##### 
		 * 위와 같은 경우에는 더이상 보지 않아도 끝까지 이동할 수 있다.
		 */

		ans = 0;
		int x = N - 1;
		int y = 0;
		dfs(0, x, y);
		System.out.println(ans);
	}

	private static void dfs(int cnt, int x, int y) {
		if (flag)
			return; // 답이 나왔으면 더이상 볼필요 없이 return
		if (cnt == N) {
			if (x == 0 && y == N - 1) {
				ans = 1;
				flag = true;
			}
			return;
		} // 가장 윗줄까지 올라간 경우

		// 캐릭터를 옮긴 후에 벽을 만난 경우
		if (map[cnt][x][y] == '#') {
			ans = 0;
			return;
		}

		// 벽을 다 지나친 경우
		if (min[cnt] > x) {
			ans = 1;
			flag = true;
			return;
		}
		for (int dir = 0; dir < dx.length; dir++) {
			int tx = x + dx[dir];
			int ty = y + dy[dir];
			if (tx >= N || ty >= N || tx < 0 || ty < 0 || map[cnt][tx][ty] == '#')
				continue;
			dfs(cnt + 1, tx, ty);
		}
	}
}
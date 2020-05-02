import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스_이근성 {
	static int N, M, D, ans, res;
	static int[] arr;

	static class Pair {
		int x, y;
		int dist;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Pair(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int[][] map;
	static int[][] saveMap;
	static List<Pair>[] attackList;

	static int dist(int p1x, int p1y, int p2x, int p2y) {
		return Math.abs(p1x - p2x) + Math.abs(p1y - p2y);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		D = Integer.parseInt(st.nextToken()); // 제한 거리

		ans = 0;
		map = new int[N + 1][M];
		saveMap = new int[N][M];
		attackList = new ArrayList[M];
		arr = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					continue;
			}
		} // end input
		copyMap(saveMap, map);
		dfs(0,0);
		System.out.println(ans);
	}

	private static boolean isEnd() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 1)
					return false;
		return true;
	}

	private static void dfs(int cnt, int idx) {
		if (idx == 3) {
			res = 0;
			while (!isEnd()) {
				res += attack();
				move();
			}
			ans = Math.max(res, ans);
			copyMap(map, saveMap);
			return;
		}
		if(cnt == M) return;
		arr[cnt] = 1;
		dfs(cnt+1, idx+1);
		arr[cnt] = 0;
		dfs(cnt+1, idx);
	}

	private static void move() {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;
				if (i == N - 1) {
					map[i][j] = 0;
					continue;
				}
				map[i + 1][j] = 1;
				map[i][j] = 0;
			}
		}
	}

	private static void copyMap(int[][] arr1, int[][] arr2) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				arr1[i][j] = arr2[i][j];
	}

	private static int attack() {
		for (int i = 0; i < M; i++) {
			attackList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			if (arr[i] == 0)
				continue;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 0)
						continue;
					int dist = dist(j, k, N, i);
					if (D >= dist) {
						attackList[i].add(new Pair(j, k, dist));
					}
				}
			}
		}
		for (int i = 0; i < attackList.length; i++) {
			Collections.sort(attackList[i], new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					int ret = o1.dist - o2.dist;
					return ret == 0 ? o1.y - o2.y : ret;
				}
			});
		}
		int ret = 0;
		for (int i = 0; i < M; i++) {
			if (attackList[i].isEmpty())
				continue;
			Pair p = attackList[i].get(0);
			if (map[p.x][p.y] == 0)
				continue;
			map[p.x][p.y] = 0;
			if (++ret == 3)
				break;
		}
		return ret;
	}

}
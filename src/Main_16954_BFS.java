
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16954_BFS {

	static int[] dx = { 0, -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 0, 1, -1, 1, -1, 1, -1 };
	static char[][] map;

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
		int N = 8;
		map = new char[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		Queue<Node> queue = new LinkedList<>();
		boolean flag = false;
		int ans = 0;
		char[][] saveMap = new char[N][N];
		
		int[] cnt = new int[15];
		int x = N-1;
		int y = 0;
		int depth = 0;
		queue.offer(new Node(x,y));
		saveMap[x][y] = 'c';
		cnt[depth]++;
		int min = 0;
		Outer:
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if(saveMap[cur.x][cur.y] != 'c') {
				if(--cnt[depth] == 0) {
					flag = true;
					for (int i = N-1; i >= 0; i--) {
						for (int j = 0; j < N; j++) {
							if (map[i][j] == '#') {
								flag = false;
								map[i][j] = '.';
								min = i+1;
								if (i == N-1)
									continue;
								map[i + 1][j] = '#';
								if(saveMap[i+1][j] == 'c') 
									saveMap[i+1][j] = '0';
							}
						}
					}
					depth++;
					if(flag) break Outer;
				}
				continue;
			}
			if(min > cur.x) {
				ans = 1;
				break;
			}
			for (int dir = 0; dir < dx.length; dir++) {
				int tx = cur.x + dx[dir];
				int ty = cur.y + dy[dir];
				if (tx >= N || ty >= N || tx < 0 || ty < 0 
						|| map[tx][ty] == '#')	continue;
				queue.offer(new Node(tx,ty));
				saveMap[tx][ty] = 'c';
				cnt[depth+1]++;
			}
			// 맵이동
			if(--cnt[depth] == 0) {
				flag = true;
				for (int i = N-1; i >= 0; i--) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == '#') {
							flag = false;
							map[i][j] = '.';
							min = i;
							if (i == N-1)
								continue;
							map[i + 1][j] = '#';
							if(saveMap[i+1][j] == 'c') 
								saveMap[i+1][j] = '0';
						}
					}
				}
				depth++;
				if(flag) break Outer;
			}
		}
		if(flag) ans = 1;
		System.out.println(ans);
	}
}
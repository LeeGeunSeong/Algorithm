import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
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

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		char[][] map = new char[C][R];
		boolean[][] visited = new boolean[C][R];
		List<Node> fire = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < C; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < R; j++) {
				if (map[i][j] == 'F')
					fire.add(new Node(i, j));
				else if (map[i][j] == 'J') {
					queue.offer(new Node(i, j));
					visited[i][j] = true;
				}
			}
		} // end input
		int sec = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int fstart = 0;
		boolean flag = true;
		Outer: while (true) {
			sec++;
			int fsize = fire.size();
			for (int i = fstart; i < fsize; i++) {
				for (int dir = 0; dir < dy.length; dir++) {
					int nx = fire.get(i).x + dx[dir];
					int ny = fire.get(i).y + dy[dir];

					if (nx < 0 || ny < 0 || nx >= C || ny >= R || map[nx][ny] == '#' || map[nx][ny] == 'F')
						continue;
					fire.add(new Node(nx, ny));
					map[nx][ny] = 'F';
				}
			}
			fstart = fsize;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node cur = queue.poll();
				for (int dir = 0; dir < dy.length; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];

					if (nx < 0 || ny < 0 || nx >= C || ny >= R)
						break Outer;

					if (map[nx][ny] == '#' || map[nx][ny] == 'F' || visited[nx][ny])
						continue;
					queue.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
			if (queue.isEmpty()) {
				flag = false;
				break;
			}
		}
		if (!flag)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(sec);
	}
}

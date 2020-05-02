import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427_불_이근성 {
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			boolean[][] visited = new boolean[H][W];
			List<Node> fire = new ArrayList<>();
			Queue<Node> queue = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if(map[i][j] == '*') fire.add(new Node(i,j));
					else if(map[i][j] == '@') {
						queue.offer(new Node(i,j));
						visited[i][j] = true;
					}
				}
			} // end input
			int sec = 0;
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			int fstart = 0;
			boolean flag = true;
			Outer:
				while(true) {
					sec++;
					int fsize = fire.size();
					for (int i = fstart; i < fsize; i++) {
						for (int dir = 0; dir < dy.length; dir++) {
							int nx = fire.get(i).x + dx[dir]; 
							int ny = fire.get(i).y + dy[dir]; 
							
							if(nx < 0 || ny < 0 || nx >= H || ny >= W
									||map[nx][ny] == '#'
									||map[nx][ny] == '*') continue;
							fire.add(new Node(nx, ny));
							map[nx][ny] = '*';
						}
					}
					fstart = fsize;
					int size = queue.size();
					for (int i = 0; i < size; i++) {
						Node cur = queue.poll();
						for (int dir = 0; dir < dy.length; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							
							if(nx < 0 || ny < 0 || nx >= H || ny >= W) break Outer;
							
							if(map[nx][ny] =='#' || map[nx][ny] == '*'
									||visited[nx][ny]) continue;
							queue.offer(new Node(nx,ny));
							visited[nx][ny] = true;
						}
					}
					if(queue.isEmpty()) {
						flag = false;
						break;
					}
				}
			if(!flag) System.out.println("IMPOSSIBLE");
			else System.out.println(sec);
		}
	}
}

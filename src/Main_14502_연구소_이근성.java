import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_이근성 {
	static int N,M,ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map,tmp;
	static boolean[][] v;
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tmp = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tmp[i][j] = map[i][j];
			}
		}
		ans = 0;
		createWall(0);
		System.out.println(ans);
	}
	private static void createWall(int cnt) {
		if(cnt == 3) {
			diffusion();
			ans = Math.max(ans, safeArea());
			newMap(map,tmp);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 || map[i][j] == 2) continue;
				map[i][j] = 1;
				tmp[i][j] = 1;
				createWall(cnt+1);
				map[i][j] = 0;
				tmp[i][j] = 0;
			}
		}
	}
	private static void newMap(int[][] map2, int[][] tmp2) {
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++) 
				map2[i][j] = tmp2[i][j];
	}
	private static void diffusion() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++) 
				if(map[i][j] == 2) q.offer(new Node(i, j));
		
		while(!q.isEmpty()) {
			Node birus = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nx = birus.x + dx[d];
				int ny = birus.y + dy[d];
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1
						|| map[nx][ny] == 2 || map[nx][ny] == 1) continue;
				map[nx][ny] = 2;
				q.offer(new Node(nx, ny));
			}
		}
	}
	private static int safeArea() {
		int ret = 0;
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++) 
				if(map[i][j] == 0) ret++;
		return ret;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x,y;
	int height;
	public Node(int x, int y, int height) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
	}
}
public class Main_2468_안전영역_이근성 {
	static int N,ans,maxAns;
	static boolean[][] visited;
	static boolean[][] isFlood;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			isFlood = new boolean[N][N];
			maxAns = 0;
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int maxHeight = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) 
					if(map[i][j] > maxHeight) 
						maxHeight = map[i][j];
			}
			for (int h = 1; h < maxHeight; h++) {
				initFlood(h);
				ans = 0;
				visited = new boolean[N][N];
				bfs();
			}
			
			if(maxAns ==0) maxAns = 1;
			System.out.println(maxAns);
	}//end main
	private static void bfs() {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		Queue<Node> queue = new LinkedList<Node>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!isFlood[i][j] && !visited[i][j]) {
					queue.offer(new Node(i,j,map[i][j]));
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						Node tmp = queue.poll();
						int x = tmp.x;
						int y = tmp.y;
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if(nx < 0 || nx > N-1 || ny < 0 || ny > N-1
									|| visited[nx][ny]
											|| isFlood[nx][ny])	continue;
							visited[nx][ny] = true;
							queue.offer(new Node(nx,ny,map[nx][ny]));
						}
					}
					ans++;
				}
			}
		}
		maxAns = Math.max(maxAns, ans);
	}
	private static void initFlood(int h) {
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				if(map[i][j] == h) isFlood[i][j] = true;
	}
}
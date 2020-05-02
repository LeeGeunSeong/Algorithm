import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main_2667 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
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
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		Stack<Node> stack = new Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					int cnt = 1;
					visited[i][j] = true;
					stack.add(new Node(i,j));
					
					while(!stack.isEmpty()) {
						Node tmp = stack.pop();
						for (int k = 0; k < 4; k++) {
							int nx = tmp.x + dx[k];
							int ny = tmp.y + dy[k];
							
							if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
							
							if(map[nx][ny] == 1 && !visited[nx][ny]) {
								visited[nx][ny] = true;
								cnt++;
								stack.add(new Node(nx,ny));
							}
						}
						
					}
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}

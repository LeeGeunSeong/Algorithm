import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출_이근성 {
	static class Node{
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] v = new boolean[R][C];
		Node S = null,D = null;
		Queue<Node> q = new LinkedList<>();
		Queue<Node> fq = new LinkedList<>();
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == '*') fq.add(new Node(i,j)); 
				else if(map[i][j] == 'S') S = new Node(i,j); 
				else if(map[i][j] == 'D') D = new Node(i,j);
			}
		}// end input
		int sec = 0;
		q.add(S);
		v[S.x][S.y]= true; 
		Outer:
		while(true) {
			sec++;
			// 이동
			int len = q.size();
			if(len == 0) {
				System.out.println("impossible");
				break;
			}
			for (int i = 0; i < len; i++) {
				Node tmp = q.poll();
				if(map[tmp.x][tmp.y] == '*') continue;
				for (int d = 0; d < dx.length; d++) {
					int nx = tmp.x + dx[d];
					int ny = tmp.y + dy[d];
					if(nx <0 || ny < 0 || nx > R-1 || ny > C-1 
							|| v[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
					if(nx == D.x && ny == D.y) {
						System.out.println(sec);
						break Outer;
					}
					q.add(new Node(nx, ny));
					v[nx][ny] = true;
				}
			}
			// 불 번짐
			int flen = fq.size();
			for (int i = 0; i < flen; i++) {
				Node tmp = fq.poll();
				for (int d = 0; d < dx.length; d++) {
					int nx = tmp.x + dx[d];
					int ny = tmp.y + dy[d];
					if(nx <0 || ny < 0 || nx > R-1 || ny > C-1 
							|| map[nx][ny] == '*' || map[nx][ny] == 'D' || map[nx][ny] == 'X') continue;
					map[nx][ny] = '*';
					fq.offer(new Node(nx, ny));
				}
			}
		}
	}
}
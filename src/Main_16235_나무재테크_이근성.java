import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16235_나무재테크_이근성 {
	static class infoTree{
		int x,y,age;
		boolean isDead;
		public infoTree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 땅 크기
		int M = Integer.parseInt(st.nextToken()); // 나무 개수
		int K = Integer.parseInt(st.nextToken()); // K년 후
		int[][] s2d2 = new int[N][N];
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) { 
				s2d2[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		LinkedList<infoTree> list = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			list.add(new infoTree(x, y, age));
		} // end input
		int[] dx = {-1,-1,-1,1,1,1,0,0};
		int[] dy = {-1,1,0,-1,1,0,1,-1};
		
		for (int year = 0; year < K; year++) {
			// spring
			for(infoTree t : list){
				if(t.age <= map[t.x][t.y]) {
					map[t.x][t.y]-= t.age++;
				}
				else t.isDead = true;
			}
			// summer
			Iterator<infoTree> it = list.iterator();
			while(it.hasNext()) {
				infoTree t = it.next();
				if(t.isDead) {
					map[t.x][t.y] += t.age / 2;
					it.remove();
				}
			}
			// fall
			LinkedList<infoTree> tmp = new LinkedList<>();
			for (infoTree t : list) {
				if(t.age%5 == 0) {
					for (int j = 0; j < 8; j++) {
						int nx = t.x + dx[j];
						int ny = t.y + dy[j];
						
						if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
						tmp.add(new infoTree(nx, ny, 1));
					}
				}
			}
			list.addAll(0,tmp);
			if(year == K-1) break;
			// winter
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++) 
					map[i][j] += s2d2[i][j];
		}
		System.out.println(list.size());
	}// end main
}

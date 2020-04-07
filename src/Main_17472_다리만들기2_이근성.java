import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2_이근성 {
	static class Node{
		int x,y;
		public Node(int x1, int y1) {
			x = x1;
			y = y1;
		}
	}
	static class Connect implements Comparable<Connect>{
		int idx,idx2;
		int dist;
		public Connect(int idx, int idx2, int dist) {
			super();
			this.idx = idx;
			this.idx2 = idx2;
			this.dist = dist;
		}
		@Override
		public int compareTo(Connect o) {
			return this.dist-o.dist;
		}
	}
	static int N,M,ans,num,INF = 1000;
	static int[] parents,dx={-1,1,0,0},dy={0,0,-1,1};
	static int[][] map,adj;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0 || v[i][j]) continue;
				Queue<Node> q = new LinkedList<>();
				q.offer(new Node(i, j));
				v[i][j] = true;
				num++;
				while(!q.isEmpty()) {
					Node c = q.poll();
					map[c.x][c.y] = num;
					for (int dir = 0; dir < dy.length; dir++) {
						int nx = c.x + dx[dir];
						int ny = c.y + dy[dir];
						
						if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1
								|| v[nx][ny] || map[nx][ny] == 0) continue;
						q.offer(new Node(nx, ny));
						v[nx][ny] = true;
					}
				}
			}
		}
		parents = new int[++num];
		Arrays.fill(parents, -1);
		adj = new int[num][num];
		for (int i = 1; i < num; i++) Arrays.fill(adj[i], INF);
		
		List<Connect> list = new ArrayList<>();
		for (int i = 1; i < num; i++) {
			for (int j = 1; j < num; j++) {
				if(i==j || adj[i][j] != INF) continue; 
				calcDist(i, j);
				if(adj[i][j] == INF) continue;
				list.add(new Connect(i, j, adj[i][j]));
			}
		}
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			Connect c = list.get(i);
			if(union(c.idx,c.idx2)) ans += c.dist;
		}
		for (int i = 1; i < num; i++) {
			for (int j = 1; j < num; j++) {
				if(i==j) continue;
				if(union(i,j)) {
					ans = -1;
				}
			}
		}
		System.out.println(ans);
	}// end main
	
	private static void calcDist(int idx, int idx2) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == idx) {
					for (int dir = 0; dir < dx.length; dir++) {
						int nx = i; int ny = j;
						cnt = 0;
						while(true) {
							nx += dx[dir]; ny += dy[dir];
							++cnt;
							if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) break; 
							if(map[nx][ny] == idx2) {
								if(cnt ==2) break;
								adj[idx][idx2] = adj[idx2][idx] = Math.min(adj[idx][idx2], cnt-1);
							}else if(map[nx][ny] != 0) {
								break;
							}
						}
					}
				}
			}
		}
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	private static int find(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = find(parents[a]);
	}
}

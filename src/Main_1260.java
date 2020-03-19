import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
	static int[][] adj;
	static int N,M,v;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		adj = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		dfs(v-1,0);
		System.out.println();
		bfs(v-1);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N];
		q.add(start);
		v[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print((cur+1) + " ");
			
			for (int i = 0; i < N; i++) {
				if(i == cur || v[i]) continue;
				if(adj[cur][i] > 0) {
					q.add(i);
					v[i] = true;
				}
			}
		}
	}

	private static void dfs(int v,int cnt) {
		if(cnt == N) return;
		
		visited[v] = true;
		System.out.print((v+1) + " ");
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			if(adj[v][i] > 0)
				dfs(i,cnt+1);
		}
	}
}

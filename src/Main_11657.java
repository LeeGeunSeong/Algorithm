import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_11657 {
	static class Node implements Comparable<Node>{
		int x,y;
		long val;
		public Node(int x, int y, long val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(Node o) {
			return this.x-o.x;
		}
	}
	static int V,E,INF = 10000000;
	static Node[] nodes;
	static long[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		nodes = new Node[E];
		dist = new long[V];
		Arrays.fill(dist, INF);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(from, to, val);
		}
		dist[0] = 0;
		if(goNegativeCycle()) {
			System.out.println(-1);
		}else {
			for (int i = 1; i < V; i++) {
				if(dist[i] == INF) dist[i] = -1;
				System.out.println(dist[i]);
			}
		}
	}
	private static boolean goNegativeCycle() {
		for (int i = 1; i <= V; i++) {
			for (Node n : nodes) {
				if(dist[n.x] == INF) continue;
				if(dist[n.y] > dist[n.x] + n.val) {
					if(i == V) return true; 
					dist[n.y] = Math.min(dist[n.x] + n.val, dist[n.	y]);
				}
			}
		}		
		return false;
	}
}

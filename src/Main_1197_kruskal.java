import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1197_kruskal {
	static class Node{
		int s,e,v;

		public Node(int s, int e, int v) {
			super();
			this.s = s;
			this.e = e;
			this.v = v;
		}
	}
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		
		for (int i = 0; i <= V; i++) 
			Arrays.fill(parent, -1);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->(o1.v-o2.v));
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			pq.offer(new Node(s, e, val));
		}
		int ans = 0;
		for (int i = 0; i < E; i++) {
			Node cur = pq.poll();
			
			if(!union(cur.s, cur.e))
				ans += cur.v;
			
		}
		System.out.println(ans);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return true;
		parent[aRoot] = b;
		return false;
	}
	private static int find(int a) {
		if(parent[a] == -1) return a;
		
		return parent[a] = find(parent[a]);
	}
	
}

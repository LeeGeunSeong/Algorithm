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

public class Main_1197 {
	static class Node{
		int e,v;

		public Node(int e, int v) {
			super();
			this.e = e;
			this.v = v;
		}


	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		LinkedList<Node>[] nodeList = new LinkedList[V+1];
		boolean[] v = new boolean[V+1];
		for (int i = 1; i <= V; i++)
			nodeList[i] = new LinkedList<Node>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			nodeList[s].add(new Node(e,val));
			nodeList[e].add(new Node(s,val));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->(o1.v-o2.v));

		pq.offer(new Node(1, 0));
		int ans = 0;
		int[] dist = new int[V+1];
		for (int i = 0; i < dist.length; i++) 
			Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int e = cur.e;
			int val = cur.v;
			
			if(v[e]) continue;
			v[e] = true; 
			ans += val;
			
			for (int i = 0; i < nodeList[e].size(); i++) {
				Node next = nodeList[e].get(i);
				if(v[next.e]) continue; 
				pq.offer(next);
			}
		}
		System.out.println(ans);
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int s = Integer.parseInt(br.readLine())-1;
		List<List<int[]>> list = new ArrayList<>();
		for (int i = 0; i < V; i++) 
			list.add(new ArrayList<int[]>());
		
		int INF = 100000000;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			list.get(u).add(new int[] {v,w});
		}
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		dist[s] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		q.offer(new int[] {s,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int bef = cur[0];
			int distance = cur[1];
			for (int i = 0; i < list.get(bef).size(); i++) {
				int[] tmp = list.get(bef).get(i);
				if(dist[tmp[0]] > distance + tmp[1]) {
					dist[tmp[0]] = distance + tmp[1];
					q.offer(new int[] {tmp[0],dist[tmp[0]]});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < V; i++) 
			sb.append((dist[i]==INF?"INF":dist[i])+"\n");
		System.out.println(sb.toString());
	}
}

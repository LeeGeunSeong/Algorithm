import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1766 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Integer>[] problemList = new ArrayList[N+1];
		int[] indegree = new int[N+1];
		for (int i = 1; i <= N; i++) 
			problemList[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			problemList[s].add(e);
			indegree[e]++;
		}
		topologicalSort(problemList, indegree);
	}

	private static void topologicalSort(List<Integer>[] problemList, int[] indegree) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int curNode = pq.poll();
			
			for (Integer next : problemList[curNode]) {
				indegree[next]--;
				
				if(indegree[next] == 0) pq.offer(next);
			}
			sb.append(curNode + " ");
		}
		System.out.println(sb.toString());
	}
}

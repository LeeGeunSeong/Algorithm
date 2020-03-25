import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) 
			list[i] = new ArrayList<>();
		
		int[] indegree = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken())-1;
			for (int j = 1; j < size; j++) {
				int next = Integer.parseInt(st.nextToken())-1;
				list[s].add(next);
				indegree[next]++;
				s = next;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) 
			if(indegree[i]==0) q.offer(i);
		
		List<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()) {
			int c = q.poll();
			ans.add(c);
			for (int i = 0; i < list[c].size(); i++) {
				int next = list[c].get(i);
				if(--indegree[next]==0) q.offer(next); 
			}
		}
		for (int i = 0; i < ans.size(); i++) {
			if(indegree[i] != 0) {
				System.out.println(0);
				return;
			}
			sb.append(ans.get(i)+1).append("\n");
		}
		System.out.println(sb.toString());
	}
}

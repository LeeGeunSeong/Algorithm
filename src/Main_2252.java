import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 위상 정렬
		int[] indegree = new int[N];
		
		List<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) 
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			list[x].add(y);
			indegree[y]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) 
			if(indegree[i] == 0) q.offer(i); // 위상이 0인 원소들 enqueue
		
		while(!q.isEmpty()) {
			int c = q.poll();
			System.out.print((c+1)+ " ");
			// 다음 node중에
			for (int i = 0; i < list[c].size(); i++) {
				int next = list[c].get(i);
				// 위상이 0인 원소들을 enqueue
				if(--indegree[next]==0) q.offer(next);
			}
		}
	}
}

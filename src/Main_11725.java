import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] parents = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) 
			list[i] = new ArrayList<Integer>();
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		parents[1] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(parents[next] > 0) continue;
				q.offer(next);
				parents[next] = cur; 
			}
		}
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i] + " ");
		}
		System.out.println(sb.toString());
	}
}

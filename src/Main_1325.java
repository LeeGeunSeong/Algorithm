import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325 {
	static boolean[] v;
	static int[] ans;
	static int N,M,max;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList[N+1];
		ans = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
		}
		max = 1;
		for (int i = 1; i <= N; i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			v = new boolean[N+1];
			q.offer(i);
			v[i] = true;
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for (int j = 0; j < list[cur].size(); j++) {
					int next = list[cur].get(j);
					if(v[next]) continue;
					v[next] = true;
					q.offer(next);
					ans[i]++;
				}
			}
			max = Math.max(max, ans[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) 
			if(max == ans[i]) sb.append(i + " ");
		
		System.out.println(sb.toString());
		
	}
}

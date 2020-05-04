import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1068 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) 
			list[i] = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = 0;
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			if(node > -1)
				list[node].add(i);
			else root = i;
		}
		
		int delNode = Integer.parseInt(br.readLine());
		
		int ans = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(delNode);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				int tmp = list[i].get(j);
				if(tmp == delNode) list[i].remove(j);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			while(!list[cur].isEmpty()) {
				q.offer(list[cur].get(0));
				list[cur].remove(0);
			}
		}
		q.offer(root);
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur==delNode) break;
			if(list[cur].isEmpty()) ans++;
			for (int i = 0; i < list[cur].size(); i++) {
				q.offer(list[cur].get(i));
			}
		}
		System.out.println(ans);
	}
}

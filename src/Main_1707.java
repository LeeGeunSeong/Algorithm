import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i < V; i++) 
				list.add(new ArrayList<>());
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				list.get(s).add(e);
				list.get(e).add(s);
			}
			boolean flag = false;
			int[] v = new int[V];
			Arrays.fill(v, -1);
			for (int i = 0; i < V; i++) {
				if(v[i] > -1) continue;
				Queue<int[]> q = new LinkedList<>();
				q.offer(new int[] {i,0});
				v[i] = 0;
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					int bef = cur[0];
					int color = cur[1];
					if(flag) break;
					for (int j = 0; j < list.get(bef).size(); j++) {
						int next = list.get(bef).get(j);
						if(v[next] == v[bef]) flag = true;
						if(v[next] == (color^1)) continue;
						q.offer(new int[] {next,color^1});
						v[next] = color^1;
					}
				}
				if(flag) break;
			}
			if(flag) System.out.println("NO");
			else System.out.println("YES");
		}
	}
}

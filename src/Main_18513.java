import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_18513 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Set<Integer> v = new HashSet<>();
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			q.offer(new int[] {tmp,0});
			v.add(tmp);
		}
		int cnt = 0;
		long ans = 0;
		int[] dx = {-1,1};
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int pos = cur[0];
			int val = cur[1];
			for (int i = 0; i < 2; i++) {
				int nx = pos + dx[i];
				if(nx < -100100000 || nx > 100100000
						|| v.contains(nx)) continue;
				ans += val+1;
				if(++cnt==K) {
					System.out.println(ans);
					return;
				}
				v.add(nx);
				q.offer(new int[] {nx,val+1});
			}
		}
		System.out.println(ans);
	}
}

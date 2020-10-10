import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19638 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(o2-o1));
		for (int i = 0; i < N; i++)
			pq.offer(Integer.parseInt(br.readLine()));
		int cnt = -1;
		while(++cnt < T) {
			int cur = pq.poll();
			if(cur < H) break;
			if(cur == 1) {
				pq.offer(1);
				break;
			}
			pq.offer((int) Math.floor((double)cur/2));
		}
		while(!pq.isEmpty()) {
			int giant = pq.poll();
			if(giant >= H) {
				System.out.println("NO");
				System.out.println(giant);
				return;
			}
		}
		System.out.println("YES");
		System.out.println(cnt);
	}
}

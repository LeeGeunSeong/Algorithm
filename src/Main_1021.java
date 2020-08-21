import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1021 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= N; i++) 
			dq.add(i);
		
		for (int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			while(true) {
				int idx = 0;
				Iterator<Integer> it = dq.iterator();
				while(it.hasNext()) {
					if(it.next() == cur)
						break;
					idx++;
				}
				if(idx == 0) {
					dq.pollFirst();
					break;
				}
				if(idx > dq.size()/2) dq.addFirst(dq.pollLast());
				else dq.addLast(dq.pollFirst());
				ans++;
			}
		}
		System.out.println(ans);
	}
}

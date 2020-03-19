import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> minq = new PriorityQueue<>();
		Queue<Integer> maxq = new PriorityQueue<>((o1,o2) -> o2-o1);
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(minq.size() == maxq.size()) maxq.offer(x);
			else minq.offer(x);
			
			if(!minq.isEmpty() && !maxq.isEmpty()) {
				if(minq.peek() < maxq.peek()) {
					minq.offer(maxq.poll());
					maxq.offer(minq.poll());
				}
			}
			sb.append(maxq.peek()+"\n");
		}
		System.out.println(sb);

	}
}

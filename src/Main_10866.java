import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			int size = dq.size();
			switch (str) {
			case "push_front":
				int tmp = Integer.parseInt(st.nextToken());
				dq.addFirst(tmp);
				break;
			case "push_back":
				tmp = Integer.parseInt(st.nextToken());
				dq.addLast(tmp);
				break;
			case "pop_front":
				if(size == 0) System.out.println(-1);
				else 
					System.out.println(dq.pollFirst());
				break;
			case "pop_back":
				if(size == 0) System.out.println(-1);
				else 
					System.out.println(dq.pollLast());
				break;
			case "size":
				System.out.println(size);
				break;
			case "empty":
				if(dq.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(size == 0) System.out.println(-1);
				else System.out.println(dq.peekFirst());
				break;
				
			case "back":
				if(size == 0) System.out.println(-1);
				else System.out.println(dq.peekLast());
				break;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<>();
		int last = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			int size = q.size();
			switch (str) {
			case "push":
				int tmp = Integer.parseInt(st.nextToken());
				q.add(tmp);
				last = tmp;
				break;
			case "pop":
				if(size == 0) System.out.println(-1);
				else 
					System.out.println(q.poll());
				break;
			case "size":
				System.out.println(size);
				break;
			case "empty":
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(size == 0) System.out.println(-1);
				else System.out.println(q.peek());
				break;
				
			case "back":
				if(size == 0) System.out.println(-1);
				else System.out.println(last);
				break;
				
			default:
				break;
			}
		}
	}
}

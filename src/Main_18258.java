import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
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
				if(size == 0) sb.append(-1+"\n");
				else 
					sb.append(q.poll()+"\n");
				break;
			case "size":
				sb.append(size+"\n");
				break;
			case "empty":
				if(q.isEmpty()) sb.append(1+"\n");
				else sb.append(0+"\n");
				break;
			case "front":
				if(size == 0) sb.append(-1+"\n");
				else sb.append(q.peek()+"\n");
				break;
				
			case "back":
				if(size == 0) sb.append(-1+"\n");
				else sb.append(last+"\n");
				break;
				
			default:
				break;
			}
		}
		System.out.println(sb.toString());
	}
}

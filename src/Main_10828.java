import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		List<Integer> stack = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			int size = stack.size();
			switch (str) {
			case "push":
				stack.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(size == 0) System.out.println(-1);
				else {
					System.out.println(stack.get(size-1));
					stack.remove(size-1);
				}
				break;
			case "size":
				System.out.println(size);
				break;
			case "empty":
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if(size == 0) System.out.println(-1);
				else System.out.println(stack.get(size-1));
				break;

			default:
				break;
			}
		}
	}
}

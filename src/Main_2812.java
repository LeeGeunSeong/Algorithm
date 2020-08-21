import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		stack.push(input.charAt(0));
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			char ch = input.charAt(i);
			while(!stack.isEmpty() && ch > stack.peek()) {
				if(cnt >= K) break;
				stack.pop();
				cnt++;
			}
			stack.push(ch);
		}
		while(!stack.isEmpty()) 
			sb.append(stack.pop());
		System.out.println(sb.reverse().substring(0,N-K));
	}
}

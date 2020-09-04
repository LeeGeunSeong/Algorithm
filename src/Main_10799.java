import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if(ch == '(') {
				stack.push(ch);
			}else {
				stack.pop();
				if(input.charAt(i-1) == '(') 
					ans += stack.size();
				else ans++;
			}
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<String> stack = new Stack<>();
		int res = 0, tmpNum = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			tmpNum = 0;
			switch (ch) {
			case '(': case '[':
				stack.push(ch+ "");
				break;
			case ')':
				if(stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				if(stack.peek().equals("(")) {
					stack.pop();
					stack.push("2");
				}else {
					while(!stack.isEmpty()) {
						char tmp = stack.peek().charAt(0);
						if(tmp == '[') {
							System.out.println(0);
							return;
						}else if(tmp == '(') {
							stack.pop();
							tmpNum *= 2;
							stack.push(String.valueOf(tmpNum));
							break;
						}else tmpNum += Integer.parseInt(stack.pop());
					}
				}
				break;
			case ']':
				if(stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				if(stack.peek().equals("[")) {
					stack.pop();
					stack.push("3");
				}else {
					while(!stack.isEmpty()) {
						char tmp = stack.peek().charAt(0);
						if(tmp == '(') {
							System.out.println(0);
							return;
						}else if(tmp == '[') {
							stack.pop();
							tmpNum *= 3;
							stack.push(String.valueOf(tmpNum));
							break;
						}else tmpNum += Integer.parseInt(stack.pop());
					}
				}
				break;
			default:
				break;
			}
		}
		while(!stack.isEmpty()) {
			char tmp = stack.peek().charAt(0);
			if(tmp == '(' || tmp == ')' || tmp == '[' || tmp == ']') {
				System.out.println(0);
				return;
			}
			res += Integer.parseInt(stack.pop());
		}
		System.out.println(res);
	}
}

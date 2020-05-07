
package olimgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SyntaxChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		boolean output = false;
		Stack<Character> stack = new Stack<>();
		outer:
		for (int i = 0; i < input.length(); i++) {
			char op = input.charAt(i);
			
			switch (op) {
			case '[': case '{': case '(':
				stack.push(op);
				break;
			case ']':
				if(!stack.isEmpty()) {
					if(stack.peek() == '[') stack.pop();
					else break outer;
				}else break outer;
				break;
			case '}':
				if(!stack.isEmpty()) {
					if(stack.peek() == '{')  stack.pop();
					else break outer;
				}else break outer;
				break;
			case ')':
				if(!stack.isEmpty()) {
					if(stack.peek() == '(') stack.pop();
					else break outer;
				}else break outer;
				break;
			default:
				break;
			}
			if(i == input.length()-1) output = true;
		}
		if(!stack.isEmpty()) output = false;
		System.out.println(output);
	}
}

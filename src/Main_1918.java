import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> op = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			switch (ch) {
			case '+': case '-': case '*': case '/':
				while(!op.isEmpty() && checkOp(ch) <= checkOp(op.peek()))
					sb.append(op.pop());
				op.push(ch);
				break;
			case '(': 
				op.push(ch);
				break;
			case ')':
				while(!op.isEmpty()) {
					char tmp = op.pop();
					if(tmp == '(') break;
					sb.append(tmp);
				}
				break;
			default:
				sb.append(ch);
				break;
			}
		}
		while(!op.isEmpty()) 
			sb.append(op.pop());
		System.out.println(sb.toString());
	}

	private static int checkOp(char ch) {
		if(ch=='(') return 0;
		if(ch=='+'|| ch=='-') return 1;
		else return 2;
	}
}

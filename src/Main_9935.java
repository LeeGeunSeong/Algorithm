import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		char[] sub = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = str.length-1; i >= 0; i--) {
			boolean flag = false;
			char ch = str[i];
			stack.push(ch);
			
			if(ch == sub[0] && stack.size() >= sub.length) {
				for (int j = 1; j < sub.length; j++) {
					if(sub[j] != stack.get(stack.size()-1-j)) {
						flag = true;
						break;
					}
				}
				if(!flag) 
					for (int j = 0; j < sub.length; j++) 
						stack.pop();
			}
		}
		int size = stack.size();
		if(size==0) sb.append("FRULA");
		else {
			for (int i = 0; i < size; i++) 
				sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> l = new Stack<>();
		Stack<Character> r = new Stack<>();
		for (int i = 0; i < str.length(); i++) 
			l.push(str.charAt(i));
		StringBuilder sb = new StringBuilder();
		int order = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < order; i++) {
			st = new StringTokenizer(br.readLine());
			char tmp = st.nextToken().charAt(0);
			if(tmp == 'P') {
				l.push(st.nextToken().charAt(0));
			}else {
				if(tmp=='L') { 
					if(!l.isEmpty()) r.push(l.pop());
				}
				else if(tmp=='D') {
					if(!r.isEmpty()) l.push(r.pop());
				}
				else {
					if(!l.isEmpty()) l.pop();
				}
			}
		}
		int len = l.size();
		for (int i = 0; i < len; i++) r.push(l.pop());
		int rlen = r.size();
		for (int i = 0; i < rlen; i++) sb.append(r.pop());
		System.out.println(sb.toString());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.length() == 1 && str.charAt(0) == '.') break;
			
			List<Character> op = new ArrayList<>();
			
			int size = -1;
			boolean f = false;
			outer:
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				switch (ch) {
				case '(': case '[':
					size++;
					op.add(ch);
					break;
				case ')':
					if(size < 0 || op.get(size) != '(') {
						f = true;
						break outer;
					}
					op.remove(size--);
					break;
				case ']':
					if(size < 0 || op.get(size) != '[') {
						f = true;
						break outer;
					}
					op.remove(size--);
					break;
				default:
					break;
				}
			}
			if(f || op.size() > 0) System.out.println("no");
			else System.out.println("yes");
		}
	}
}

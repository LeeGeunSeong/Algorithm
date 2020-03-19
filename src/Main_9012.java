import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			
			List<Character> op = new ArrayList<>();
			
			int size = -1;
			boolean f = false;
			outer:
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				switch (ch) {
				case '(': 
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
				default:
					break;
				}
			}
			if(f || op.size() > 0) System.out.println("NO");
			else System.out.println("YES");
		}
	}
}

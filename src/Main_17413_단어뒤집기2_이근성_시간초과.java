import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17413_단어뒤집기2_이근성_시간초과 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		for (int i = 0; i < str.length();) {
			char ch = str.charAt(i);
			if(ch == ' ') sb.append(str.charAt(i++)); 
			else if(ch == '<') {
				while(str.charAt(i) != '>') {
					sb.append(str.charAt(i++));
				}
				sb.append(str.charAt(i++));
			}else {
				String tmp = "";
				while(i < str.length() && str.charAt(i) != '<'
						&& str.charAt(i) != ' ') {
					tmp += str.charAt(i++);
				}
				sb.append(ReverseString(tmp));
			}
		}
		
		System.out.println(sb);
	}
	private static String ReverseString(String tmp) {
		String str = "";
		for (int i = tmp.length()-1; i >= 0; i--) 
			str += tmp.charAt(i);
		return str;
	}
}
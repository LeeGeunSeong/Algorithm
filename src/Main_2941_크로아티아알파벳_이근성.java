import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941_크로아티아알파벳_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			cnt++;
			switch (ch) {
			case 'c': 
				if(i < len-1 && (str.charAt(i+1) == '='|| str.charAt(i+1) == '-')) i++;
				break;
			case 'd':
				if(i < len-1) {
					if(i < len-2 && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') i += 2;
					else if(str.charAt(i+1) == '-') i++;
					else continue;
				}
				break;
			case 'l': case 'n':
				if(i < len-1 && str.charAt(i+1) == 'j') i++;
				break;
			case 's': case 'z':
				if(i < len-1 && str.charAt(i+1) == '=') i++;
				break;
			default:
				break;
			}
		}
		System.out.println(cnt);
	}
}

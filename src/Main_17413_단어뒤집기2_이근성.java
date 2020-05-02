import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17413_단어뒤집기2_이근성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] chs = br.readLine().toCharArray();
		
		StringBuilder tmp = new StringBuilder();
		boolean flag = false;
		for (Character ch : chs) {
			switch (ch) {
			case '<':
				if(!flag) sb.append(tmp.reverse());
				else sb.append(tmp);
				sb.append(ch);
				tmp.setLength(0);
				flag = true;
				break;
			case '>':
				sb.append(tmp);
				sb.append(ch);
				tmp.setLength(0);
				flag = false;
				break;
			case ' ':
				if(!flag) sb.append(tmp.reverse());
				else sb.append(tmp);
				sb.append(ch);
				tmp.setLength(0);
				break;
			default:
				tmp.append(ch);
				break;
			}
		}
		sb.append(tmp.reverse());
		System.out.println(sb);
	}
}

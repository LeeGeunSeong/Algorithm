import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5622_다이얼_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sec = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch <= 'C') sec += 3;
			else if(ch > 'C' && ch <= 'F') sec += 4;
			else if(ch > 'F' && ch <= 'I') sec += 5;
			else if(ch > 'I' && ch <= 'L') sec += 6;
			else if(ch > 'L' && ch <= 'O') sec += 7;
			else if(ch > 'O' && ch <= 'S') sec += 8;
			else if(ch > 'S' && ch <= 'V') sec += 9;
			else if(ch > 'V' && ch <= 'Z') sec += 10;
		}
		System.out.println(sec);
	}
}

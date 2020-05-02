import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_8958_OX퀴즈_이근성 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			
			char[] ch = br.readLine().toCharArray();
			int ans = 0;
			for (int i = 0; i < ch.length; i++) {
				int cnt = 1;
				if(ch[i] == 'O') {
					for (int j = i; j < ch.length && ch[j] == 'O'; j++) {
						ans += cnt++; 
						ch[j] = 'X';
					}
				}
			}
			System.out.println(ans);
		}
	}//end main
}
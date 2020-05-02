import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1316_그룹단어체커_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		int cnt = 0;
		outer:
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int len = str.length();
			Arrays.fill(alpha, -1);
			char c = str.charAt(0);
			alpha[c-'a']++;
			for (int j = 1; j < len; j++) {
				char tmp = str.charAt(j);
				if(tmp != c && alpha[tmp-'a'] > -1) {
					continue outer;
				}
				alpha[tmp-'a']++;
				c = tmp;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675_문자열반복_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			int len = str.length();
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(str.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

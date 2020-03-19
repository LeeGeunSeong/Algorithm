import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		String S = br.readLine();
		
		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < M-2; i++) {
			if(S.charAt(i)== 'I' && S.charAt(i+1)=='O' && S.charAt(i+2) == 'I') {
				cnt++;
				if(cnt == N) {
					cnt--;
					ans++;
				}
				i++;
			}else cnt = 0;
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String res = br.readLine();
			int ans = 0, add = 0;
			for (int i = 0; i < res.length(); i++) {
				char ch = res.charAt(i);
				if(ch=='O') {
					ans += ++add;
				}else add = 0;
			}
			System.out.println(ans);
		}
	}
}

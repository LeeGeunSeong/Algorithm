import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans = 0;
		for (int i = 0; i < 5; i++) {
			int x = Integer.parseInt(st.nextToken());
			ans += Math.pow(x, 2);
		}
		
		System.out.println(ans%10);
	}
}

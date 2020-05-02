import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1011_FlymetotheAlphaCentauri_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dist = -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			int n = (int) Math.ceil(Math.sqrt(dist));
			int ans = (n<<1) - 1;
			System.out.println((n*n-n)>=dist?ans-1:ans);
		}
	}
}

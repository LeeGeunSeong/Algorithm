import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(isPrime(x)) ans++;
		}
		System.out.println(ans);
	}

	private static boolean isPrime(int x) {
		if(x < 2) return false;
		for (int i = 2; i < x; i++) {
			if(x%i == 0) return false;
		}
		return true;
	}
}

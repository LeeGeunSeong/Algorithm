import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = M; i <= N; i++) {
			if(isPrime(i)) System.out.println(i);
		}
	}

	private static boolean isPrime(int i) {
		if(i < 2) return false;
		int j = 2;
		while(j*j <= i) {
			if(i%j++ ==0) return false;
		}
		return true;
	}
}

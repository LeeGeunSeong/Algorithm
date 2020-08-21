import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i <= N; i++) {
			for (int j = 2; i*j <= N; j++) {
				isPrime[i*j] = false;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			if(!isPrime[i]) continue;
			if(N%i==0) {
				sb.append(i + "\n");
				N /= i--;
			}
		}
		System.out.println(sb.toString());
	}
}

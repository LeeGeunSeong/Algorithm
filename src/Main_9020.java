import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[10001];
		int len = (int) Math.sqrt(prime.length);
		for (int i = 0; i < prime.length; i++) 
			prime[i] = true;
		
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i <= len; i++) 
			for (int j = 2; j*i < prime.length; j++) 
				prime[i*j] = false;
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			outer:
			for (int i = N/2; i > 0; i--) {
				if(!prime[i]) continue;
				for (int j = i; j < N; j++) {
					if(!prime[j]) continue;
					if(i+j == N) {
						System.out.println(i+" " + j);
						break outer;
					}
				}
			}
		}
	}
}

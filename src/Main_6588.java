import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_6588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int len = 1000001;
		boolean[] prime = new boolean[len];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i < len; i++) 
			for (int j = 2; j * i < len; j++) 
				prime[i*j] = false;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int a = -1, b = -1;
				for (int i = 3; i <= n/2; i++) {
					if(!prime[i] || i%2==0) continue;
					if(prime[n-i]) {
						a = i; b = n-i;
						break;
					}
				}
			if(a == -1 && b == -1) sb.append("Goldbach's conjecture is wrong.\n");
			else sb.append(n + " = " + a + " + " + b + "\n");
		}
		System.out.println(sb.toString());
	}
}

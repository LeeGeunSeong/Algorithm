import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_18856 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[1001];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		isPrime[0] = false;
		
		for (int i = 2; i <= 1000; i++) {
			for (int j = 2; i*j <= 1000; j++) {
				isPrime[i*j] = false;
			}
		}
		int[] arr = new int[N];
		arr[0] = 1;
		arr[1] = 2;
		int idx = 3;
		for (int i = 2; i < N; i++) {
			if(isPrime[idx]) {
				arr[i] = idx;
				isPrime[idx] = false;
			}else 
				while(true) {
					if(isPrime[++idx]) {
						arr[i] = idx;
						isPrime[idx] = false;
						break;
					}
				}
		}
		System.out.println(N);
		for (int i = 0; i < N; i++) 
			System.out.print(arr[i] + " ");
		
	}
}

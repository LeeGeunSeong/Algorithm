import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2981 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) 
			num[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		int M = num[1] - num[0];
		for (int i = 2; i < N; i++) {
			M = gcd(M,num[i]-num[i-1]);
		}
		for (int i = 2; i <= M; i++) 
			if(M%i ==0) sb.append(i + " ");
		System.out.println(sb.toString());
	}

	private static int gcd(int a, int b) {
		if(a%b==0) return b;
		return gcd(b,a%b);
	}
}

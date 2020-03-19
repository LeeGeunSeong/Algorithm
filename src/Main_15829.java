import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15829 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = 1234567891;
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long ans = 0;
		long[] r = new long[50];
		r[0] = 1;
		for (int i = 1; i < 50; i++) {
			r[i] = (r[i-1] * 31) % M;
		}
		for (int i = 0; i < L; i++) {
			int num = str.charAt(i)-'a'+1;
			ans = (ans + num * r[i]) % M;
		}
		System.out.println(ans%M);
	}
}

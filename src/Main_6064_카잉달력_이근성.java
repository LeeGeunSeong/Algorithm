import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6064_카잉달력_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int n = 0,cnt = 0;
			while(cnt < N) {
				n = x + M *(cnt++);
				int div = n%N==0?N:n%N;
				if(div == y) break;
			}
			System.out.println(n>lcm(M,N)?-1:n);
		}
	}
	private static int lcm(int m, int n) {
		return m*n/gcd(m,n);
	}
	private static int gcd(int m, int n) {
		while(n!=0) {
			int r = m%n;
			m = n;
			n = r;
		}
		return m;
	}
}

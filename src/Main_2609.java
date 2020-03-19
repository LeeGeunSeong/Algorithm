import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int g = gcd(a,b);
		
		System.out.println(g);
		System.out.println(a*b/g);
	}

	private static int gcd(int a, int b) {
		if(a > b) {
			if(a%b == 0) return b;
			return gcd(a%b,b);
		}else {
			if(b%a == 0) return a;
			return gcd(b%a,a);
		}
	}
}

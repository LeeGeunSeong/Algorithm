import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19575 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		long res = 0;
		int p = (int) (Math.pow(10, 9) + 7);
		long[] pow = new long[N+1];
		pow[0] = 1;
		
		for (int i = 1; i <= N; i++) 
			pow[i] = (pow[i-1]*x)%p;
		
		for (int idx = 0; idx <= N; idx++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			res += (a * pow[i])%p;
		}
		
		System.out.println(res%p);
	}
}

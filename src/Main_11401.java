import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11401 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long p = 1000000007;
		long[] fac = new long[N+1];
		fac[0] = 1;
		fac[1] = 1;
		for (int i = 2; i <= N; i++) 
			fac[i] = (fac[i-1]*i)%p;
		long nk = (fac[K] * fac[N-K])%p;
		
		long idx = p-2;
		long mul = 1;
		while(idx > 0) {
			if(idx%2 == 1) {
				mul *= nk;
				mul %= p;
			}
			nk = (nk*nk)%p;
			idx /=2;
		}
		long res = ((fac[N]%p)*(mul%p))%p;
		System.out.println(res);
	}
}

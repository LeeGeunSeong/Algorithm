import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407 {
	static BigInteger[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		arr = new BigInteger[N+1][M+1];
		System.out.println(String.valueOf(combi(N,M)));
	}

	private static BigInteger combi(int n, int m) {
		if(n==m || m == 0) return BigInteger.ONE;
		if(arr[n][m] != null) return arr[n][m];
		arr[n][m] = new BigInteger("0");
		return arr[n][m] = arr[n][m].add(combi(n-1, m-1)).add(combi(n-1, m));
	}
}

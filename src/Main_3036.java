import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3036 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] rad = new int[N];
		for (int i = 0; i < N; i++) 
			rad[i] = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < N; i++) {
			int gcd = gcd(rad[0],rad[i]);
			sb.append(rad[0]/gcd + "/" + rad[i]/gcd + "\n");
		}
		System.out.println(sb.toString());
	}

	private static int gcd(int a, int b) {
		if(a%b==0) return b;
		return gcd(b,a%b);
	}
	
}

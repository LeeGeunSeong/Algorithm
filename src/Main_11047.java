import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) 
			coin[i] = Integer.parseInt(br.readLine());
			
		int idx = 0;
		while(idx < N-1 && K - coin[idx++] > 0);
		
		int ans = 0;
		
		while(K > 0) {
			ans += K/coin[idx];
			K = K - (K/coin[idx])*coin[idx--];
		}
		System.out.println(ans);
	}
}

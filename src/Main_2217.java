import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		int[] count = new int[10001];
		int max = 0;
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
			count[rope[i]]++;
			max = Math.max(max, rope[i]);
		}
		
		for (int i = max; i > 0; i--) 
			count[i-1] += count[i];
		int ans = 0;
		for (int i = 1; i <= max; i++) 
			ans = Math.max(ans, i*count[i]);
		System.out.println(ans);
	}
}

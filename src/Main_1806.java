import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()); 
		int res = Integer.MAX_VALUE;
		int l = 0, r = 0, sum = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		while(true) {
			if(sum >= S) {
				sum -= arr[l++];
				res = Math.min(res, r-l+1);
			}else if(r == N) break;
			else sum += arr[r++];
		}
		System.out.println(res == Integer.MAX_VALUE?0:res);
	}
}

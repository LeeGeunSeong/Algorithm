import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] lan = new int[K];
		long min = 1, max = 0;
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(lan[i], max);
		}
		long mid = 0;
		while(min <= max) {
			int num = 0;
			mid = (min + max)/2;
			for (int i = 0; i < K; i++) {
				num += lan[i]/mid;
			}
			if(num < N) {
				max = mid-1;
			}else {
				min = mid+1;
			}
		}
		System.out.println(max);
	}
}
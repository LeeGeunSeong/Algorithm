import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int sum = 0, ans = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans = Math.max(arr[i], ans);
			sum += arr[i];
		}
		
		int M = Integer.parseInt(br.readLine());
		if(sum > M) {
			int avg = M/N, diff = 0,cnt = 0;
			for (int i = 0; i < N; i++)
				if(avg < arr[i]) {
					diff += avg;
					cnt++;
				}
				else diff += arr[i];
			ans = avg + (M-diff)/cnt;
		}
		System.out.println(ans);
	}
}

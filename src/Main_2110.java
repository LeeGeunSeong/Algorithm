import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int l = 1, r = arr[N-1] - arr[0];
		int ans = 0, dist = 0;
		
		while(l <= r) {
			int m = (l+r)/2;
			int s = arr[0];
			int cnt = 1;
			
			for (int i = 1; i < N; i++) {
				dist = arr[i] - s;
				if(m <= dist) {
					cnt++;
					s = arr[i];
				}
			}
			if(cnt >= C) {
				ans = m;
				l = m+1;
			}else r = m-1;
		}
		System.out.println(ans);
	}
}

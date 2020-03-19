import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2855_흥미로운수열_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine()) + arr[i-1];
		
		int ans = 0,l,r,m;
		for (int i = 1; i <= N; i++) {
			l = i; r = (N+i-1)/2; ans = 0;
			while(l<=r) {
				m = (l+r)/2;
				int len = m-i+1;
				if(arr[m] - arr[i-1] > S) r = m-1;
				else {
					l = m + 1;
					ans = Math.max(ans, len);
				}
			}
			while(arr[2*ans + i-1] - arr[ans+i-1] > S) ans--;
			sb.append(ans<<1).append("\n");
		}
		System.out.println(sb);
	}
}

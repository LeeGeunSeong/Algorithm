import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr,(o1,o2)->(o1[0]-o2[0]));
			int max = arr[0][1];
			int ans = 1;
			Arrays.sort(arr,(o1,o2)->(o1[1]-o2[1]));
			int min = arr[0][0];
			for (int i = 0; i < max-1; i++) {
				if(arr[i][0] > min) continue;
				min = arr[i][0];
				ans++;
			}
			System.out.println(ans);
		}
	}
}

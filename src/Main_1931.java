import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2]; 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1];
			}
		});
		 
		int ans = 0;
		int t = 0;
		
		for (int i = 0; i < N; i++) {
			if(time[i][0] >= t) {
				t = time[i][1];
				ans++;
			}
		}
		System.out.println(ans);
	}
}

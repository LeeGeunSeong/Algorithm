import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654 {
	static int N,M;
	static int[] arr;
	static int[] ans;
	static boolean[] v;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		ans = new int[M];
		v = new boolean[N];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb.toString());
	}
	private static void dfs(int cnt) {
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			ans[cnt] = arr[i];
			v[i] = true;
			dfs(cnt+1);
			v[i] = false;
		}
	}
}

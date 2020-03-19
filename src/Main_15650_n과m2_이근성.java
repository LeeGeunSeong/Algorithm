import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15650_n과m2_이근성 {
	static int N,M;
	static int[] arr;
	static boolean[] v;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		Arrays.fill(arr, 10000);
		v = new boolean[N+1];
		DFS(0);
		
		System.out.println(sb);
	}
	private static void DFS(int cnt) {
		for (int i = 1; i < M; i++) if(arr[i] < arr[i-1]) return;
		
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(v[i]) continue;
			arr[cnt] = i;
			v[i] = true;
			DFS(cnt+1);
			arr[cnt] = 1000;
			v[i] = false;
		}
	}
}

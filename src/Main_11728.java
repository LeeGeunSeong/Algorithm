import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ans = new int[N+M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) ans[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) ans[i+N] = Integer.parseInt(st.nextToken());
		Arrays.sort(ans);
		
		for (int i = 0; i < ans.length; i++) sb.append(ans[i] + " "); 
		
		System.out.println(sb.toString());
		
	}
}

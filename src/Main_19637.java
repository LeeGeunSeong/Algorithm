import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_19637 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] title = new String[N];
		int[] limit = new int[N];
		for (int i = 0; i < N; i++) { 
			st = new StringTokenizer(br.readLine());
			title[i] = st.nextToken();
			limit[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(br.readLine());
			int idx;
			for (idx = 0; idx < N; idx++) {
				if(input <= limit[idx]) break;
			}
			sb.append(title[idx] + "\n");
		}
		System.out.println(sb.toString());
	}
}

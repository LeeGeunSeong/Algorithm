import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_9466 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] next = new int[N+1];
			for (int i = 1; i <= N; i++)
				next[i] = Integer.parseInt(st.nextToken());
			int ans = N;
			boolean[] v = new boolean[N+1];
			
			for (int i = 1; i <= N; i++) {
				if(v[i]) continue;
				List<Integer> list = new ArrayList<>();
				int cnt = 0, cur = i;
				while(true) {
					cnt++;
					list.add(cur);
					cur = next[cur];
					if(cur == i) {
						ans -= cnt;
						for (int j = 0; j < list.size(); j++) {
							v[list.get(j)] = true;
						}
						break;
					}
					if(cur == next[cur] || v[cur]) break;
				}
			}
			System.out.println(ans);
		}
	}
}

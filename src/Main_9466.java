import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_9466 {
	static int N,ans;
	static int[] next;
	static boolean[] v,check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
//			N = 100000;
			StringTokenizer st = new StringTokenizer(br.readLine());
			next = new int[N+1];
			for (int i = 1; i <= N; i++)
				next[i] = Integer.parseInt(st.nextToken());
//			for (int i = 1; i <= N; i++)
//				next[i] = i+1;
			ans = 0;
			check = new boolean[N+1];
			v = new boolean[N+1];
			for (int i = 1; i <= N; i++) 
				solve(i);
			
			System.out.println(N-ans);
		}
	}
	private static void solve(int i) {
		if(check[i]) return;
		check[i] = true;
		if(!check[next[i]])	solve(next[i]);
		else if(!v[next[i]]) {
			ans++;
			for (int j = next[i]; j != i; j = next[j]) 
				ans++;
		}
		v[i] = true;
	}
}

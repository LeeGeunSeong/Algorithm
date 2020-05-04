import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1062 {
	static int N,K,ans;
	static int[] count,select;
	static boolean[] v;
	static String[] word;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(K < 5) {
			System.out.println(0);
		}else {
			count = new int[26];
			select = new int[K];
			v = new boolean[26];
			word = new String[N];
			ans = 0;
			v[0] = v[2] = v[8] = v[13] = v[19] = true;
			for (int i = 0; i < N; i++) {
				word[i] = br.readLine().replace("anta", "").replace("tica", "");
			}
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < word[i].length(); j++) 
					count[word[i].charAt(j)-'a']++;
			solve(0,0);
			System.out.println(ans);
			
		}
	}

	private static void solve(int idx, int cnt) {
		if(cnt == K-5) {
			ans = Math.max(ans, check());
			return;
		}
		boolean flag = false;
		for (int i = idx+1; i < 26; i++) {
			if(count[i] == 0 || v[i]) continue;
			flag = true;
			select[cnt] = i;
			v[i] = true;
			solve(i,cnt+1);
			v[i] = false;
		}
		if(!flag) ans = Math.max(ans, check());
	}
	private static int check() {
		int ret = 0;
		outer:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < word[i].length(); j++) 
				if (!v[word[i].charAt(j)-'a']) continue outer;
			ret++;
		}
		return ret;
	}
}

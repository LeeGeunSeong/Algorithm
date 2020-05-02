import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
	static int L,C;
	static char[] arr,ans;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new char[C];
		ans = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) arr[i] = st.nextToken().charAt(0);			
		Arrays.sort(arr);
		
		dfs(0,0);
		
		System.out.println(sb.toString());
	}
	private static void dfs(int cnt, int idx) {
		if(idx==L) {
			if(check()) {
				for (int i = 0; i < ans.length; i++) 
					sb.append(ans[i]);
				sb.append("\n");
			}
			return;
		}
		if(cnt == C) return;
		
		ans[idx] = arr[cnt];
		dfs(cnt+1,idx+1);
		ans[idx] = ' ';
		dfs(cnt+1,idx);
	}
	private static boolean check() {
		int vow = 0, cons = 0;
		for (int i = 0; i < L; i++) {
			char ch = ans[i];
			switch (ch) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				vow++;
				break;
			default:
				cons++;
				break;
			}
		}
		if(vow<1 || cons <2) return false;
		return true;
	}
}

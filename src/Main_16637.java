import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16637 {
	static int N,ans;
	static char[] ch;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ch = br.readLine().toCharArray();
		arr = new int[N];
		ans = Integer.MIN_VALUE;
		if(N <= 3) {
			if(N == 1) System.out.println(ch[0]-'0');
			else {
				int cal = cal(ch[0]-'0',ch[2]-'0',ch[1]);
				
				
				System.out.println(cal);
			}
		}else {
			dfs(2);
			System.out.println(ans);
		}
		
	}
	private static int cal(int i, int j, char ch) {
		int ret = 0;
		switch (ch) {
		case '+':
			ret = i + j;
			break;
		case '-':
			ret = i - j;
			break;
		case '*':
			ret = i * j;
			break;

		default:
			break;
		}
		return ret;
	}
	private static void dfs(int cnt) {
		if(cnt == N-1) {
			if(arr[cnt-2] == 1) arr[cnt] = 2;
			ans = Math.max(ans, calc());
			return;
		}
		
		if(arr[cnt-2] != 1) arr[cnt] = 1;
		else if(arr[cnt-2] == 1) arr[cnt] = 2;
		dfs(cnt+2);
		if(arr[cnt] == 1) {
			arr[cnt] = 0;
			arr[cnt+2] = 0;
		}
		dfs(cnt+2);
	}
	private static int calc() {
		int ret = ch[0]-'0';
		
		for (int i = 0; i < arr.length; i++) {
			if(i%2 ==1) continue;
			if(arr[i] == 1 && i > 0) ret = cal(ret,cal(ch[i]-'0',ch[i+2]-'0',ch[i+1]),ch[i-1]);
			else if(arr[i] == 2) continue;
			else if(arr[i] == 0 && i > 0) ret = cal(ret,ch[i]-'0',ch[i-1]);
		}
		return ret;
	}
}

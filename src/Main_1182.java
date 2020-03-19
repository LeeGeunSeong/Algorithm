import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1182 {
	static int N,S,ans;
	static int[] arr,num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		num = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		dfs(0,0);
		System.out.println(ans);
	}
	private static void dfs(int cnt, int idx) {
		if(cnt == N) {
			if(idx == 0) return;
			int sum = 0;
			for (int i = 0; i < idx; i++) 
				sum += num[i];
			if(sum == S) ans++;
			return;
		}
		
		num[idx] = arr[cnt];
		dfs(cnt+1,idx+1);
		num[idx] = 0;
		dfs(cnt+1,idx);
	}
}

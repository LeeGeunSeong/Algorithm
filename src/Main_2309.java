import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309 {
	static int[] height,ans;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		height = new int[9];
		ans = new int[7];
		for (int i = 0; i < 9; i++) 
			height[i] = Integer.parseInt(br.readLine());
		dfs(0,0);
	}
	private static void dfs(int cnt, int idx) {
		if(!flag) {
			if(idx == 7) {
				int sum = 0;
				for (int i = 0; i < 7; i++) 
					sum += ans[i];
				if(sum == 100) {
					flag = true;
					Arrays.sort(ans);
					for (int i = 0; i < 7; i++) 
						System.out.println(ans[i]);
				}
				return;
			}
			if(cnt == 9) return;
			
			ans[idx] = height[cnt];
			dfs(cnt+1,idx+1);
			ans[idx] = 0;
			dfs(cnt+1,idx);
		}
	}
}

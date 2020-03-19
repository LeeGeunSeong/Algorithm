import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603 {
	static int k;
	static int[] arr,num;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			arr = new int[k];
			num = new int[6];
			
			for (int i = 0; i < k; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			dfs(0,0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(int cnt, int idx) {
		if(idx == 6) {
			for (int i = 0; i < 6; i++) 
				sb.append(num[i] + " ");
			sb.append("\n");
			return;
		}
		if(cnt==k) return;
		
		num[idx] = arr[cnt];
		dfs(cnt+1,idx+1);
		num[idx] = 0;
		dfs(cnt+1,idx);
	}
}

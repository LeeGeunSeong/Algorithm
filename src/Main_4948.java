import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_4948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] v = new boolean[246913];
		Arrays.fill(v, true);
		v[0] = false;
		v[1] = false;
		for (int i = 2; i < v.length; i++) {
			for (int j = 2; j*i < v.length; j++) {
				v[i*j] = false;
			}
		}
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int ans = 0;
			for (int i = n+1; i <= 2*n; i++) 
				if(v[i]) ans++;
			sb.append(ans+"\n");
		}
		System.out.println(sb.toString());
	}
}

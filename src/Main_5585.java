import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5585 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 1000 - Integer.parseInt(br.readLine());
		
		int[] coin = {500,100,50,10,5,1};
		int idx = 0, ans = 0;
		while(N > 0) {
			if(N >= coin[idx]) { 
				while(N >= coin[idx]) {
					N -= coin[idx];
					ans++;
				}
			}else idx++;
		}
		System.out.println(ans);
	}
}

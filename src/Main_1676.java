import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine())+1;
		int ans = 0;
		
		while(N-->1) {
			int tmp = N;
			
			while(tmp%2 == 0 || tmp%5 == 0) {
				if(tmp%2==0) tmp/= 2;
				if(tmp%5==0) { 
					tmp/= 5;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}

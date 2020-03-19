import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
	static int N,r,c,ans,tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		divide(0,(int)Math.pow(2, N));
		System.out.println(ans);
	}
	private static void divide(int s, int n) {
		int x = 0, y = 0;
		while(n > 0) {
			n /= 2;
			if(r < x + n && c < y + n) ans += n*n*0;
			else if(r < x + n) {
				ans += n*n*1;
				y += n;
			}else if(c < y + n) {
				ans += n*n*2;
				x += n;
			}else {
				ans += n*n*3;
				x += n; y += n;
			}
			if(n == 1) break;
			
		}
	}
}

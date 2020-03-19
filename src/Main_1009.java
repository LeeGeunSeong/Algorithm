import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = a%10;
			for (int i = 1; i < (b%4==0?b%4+4:b%4); i++) 
				x = (x*a)%10;
			System.out.println(x==0?10:x);
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] num = br.readLine().split(",");
			System.out.println((num[0].charAt(0)-'0') + (num[1].charAt(0)-'0')); 
		}
	}
}

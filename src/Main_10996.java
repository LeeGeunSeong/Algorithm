import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			if(i%2==1) {
				sb.append(" ");
				for (int j = 0; j < N/2; j++) 
					sb.append("* ");
			}else {
				for (int j = 0; j <= (N-1)/2; j++) 
					sb.append("* ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

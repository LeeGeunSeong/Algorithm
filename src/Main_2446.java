import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int max = 2*N-1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) 
				sb.append(" ");
			
			for (int j = 0; j < max; j++) 
				sb.append("*");
			sb.append("\n");
			max -= 2;
		}
		max = 1;
		for (int i = N-2; i >=0; i--) {
			max += 2;
			for (int j = 0; j < i; j++) 
				sb.append(" ");
			
			for (int j = 0; j < max; j++) 
				sb.append("*");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

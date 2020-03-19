import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2442 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int idx = 1;
		for (int i = N; i > 0; i--) {
			for (int j = 1; j < i; j++) 
				sb.append(" ");
			for (int j = 0; j < idx*2-1; j++) 
				sb.append("*");
			idx++;
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

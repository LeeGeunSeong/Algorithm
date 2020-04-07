import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1193_분수찾기_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int n = 1;
		if(A==1) {}
		else {
			while(true) {
				int min = 3 * n * n - 3 * n + 2;
				n++;
				int max = 3 * n * n - 3 * n + 1;
				if(A >= min && A <= max) break; 
			}
		}
		System.out.println(n);
	}
}

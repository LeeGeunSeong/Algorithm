import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2292_벌집_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int n = 1;
		if(A==1) System.out.println("1/1");
		else {
			int min = 0;
			while(true) {
				min = (n * n - n)/2 + 1;
				n++;
				int max = (n * n - n)/2;
				if(A >= min && A <= max) break; 
			}
			int idx = A % min;
			if((n-- & 1) == 0) System.out.println((n - idx) + "/" + (idx+1));
			else System.out.println((idx+1) + "/" + (n-idx));
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2839_설탕배달_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		
		int ans = -1;
		for (int i = 0; i <= 5; i++) {
			if(A >= 3* i && (A-(3*i))%5 == 0) {
				ans = (A-(3*i))/5 + i;
				break;
			}
		}
		System.out.println(ans);
	}
}

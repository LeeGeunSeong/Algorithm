import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19582 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int max = 0, yd = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if(yd <= l) {
				yd += p;
				max = Math.max(max, p);
			}else if(yd -max > l || max < p) count--;
			else {
				count--;
				yd -= max - p;
			}
			if(count < 0) {
				System.out.println("Zzz");
				return ;
			}
		}
		
		System.out.println("Kkeo-eok");
	}
}

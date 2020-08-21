import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19572 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		int d3 = Integer.parseInt(st.nextToken());
		
		int flag = -1;
		double[] res = new double[3]; // 0,1 0,2 1,2
		for (double i = 0.5; i < d1; i+= 0.5) {
			res[0] = i;
			res[1] = d1 - res[0];
			res[2] = d2 - res[0];
			if(res[1] <= 0.0 || res[2] <= 0.0) continue;
			if(d1 == (int)(res[0] + res[1]) && d2 == (int)(res[0] + res[2]) && d3 == (int)(res[1] + res[2])) {
				flag = 1;
				break;
			}
		}
		if(flag == 1) {
			System.out.println(flag);
			System.out.printf("%.1f %.1f %.1f",res[0],res[1],res[2]);
		}else System.out.println(flag);
	}
}

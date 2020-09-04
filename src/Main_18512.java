import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P1 = Integer.parseInt(st.nextToken());
		int P2 = Integer.parseInt(st.nextToken());
		while(true) {
			if(P1 > P2) {
				P2 += Y;
			}else if(P1 < P2){
				P1 += X;
			}else {
				System.out.println(P1);
				return ;
			}
			if(P1 > 10000 || P2 > 10000) break;
		}
		System.out.println(-1);
	}
}
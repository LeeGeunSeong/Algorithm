import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] broken = new int[M];
		StringTokenizer st = null;
		if(M > 0) st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < M; i++) 
			broken[i] = Integer.parseInt(st.nextToken());
		
		int start = 100;
		int ans = Math.abs(N-start);
		int mcnt = 0,pcnt=0;
		boolean f = false;
		outer:
		for (int i = 0; i < broken.length; i++) {
			int end = N;
			if(end == 0 && end== broken[i]){
				f = true;
				break;
			} 	
			while(end > 0) {
				if(end%10 == broken[i]) {
					f = true;
					break outer;
				}
				end /= 10;
			}
		}
		if(f) {
			while(true) {
				mcnt++; pcnt++;
				int minus = N-mcnt;
				int plus = N+pcnt;
				boolean fm = false, fp = false;
				outer1:
					for (int i = 0; i < M; i++) {
						int tmp = minus;
						if(minus < 0) {
							fm = true;
							break;
						}
						if(tmp == 0 && tmp == broken[i]){
							fm = true;
							break;
						} 				
						
						while(tmp > 0) {
							if(tmp%10 == broken[i]) {
								fm = true;
								break outer1;
							}
							tmp /= 10;
						}
					}
				outer2:
					for (int i = 0; i < M; i++) {
						int tmp = plus;
						while(tmp > 0) {
							if(tmp%10 == broken[i]) {
								fp = true;
								break outer2;
							}
							tmp /= 10;
						}
					}
					if(!fm) {
						ans = Math.min(ans, mcnt + String.valueOf(minus).length());
						break;
					}else if(!fp) {
						ans = Math.min(ans, pcnt + String.valueOf(plus).length());
						break;
					}else if(ans < pcnt || ans < mcnt) break;
			}
		}else ans = Math.min(ans, String.valueOf(N).length());
		System.out.println(ans);
	}
}

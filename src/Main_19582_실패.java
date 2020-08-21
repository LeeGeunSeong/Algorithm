import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19582_실패 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] limit = new int[N];
		int[] price = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			limit[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		int count = limit[0]==0?1:0;
		int max = 0;
		int yd = 0;
		for (int i = 0; i < N-1; i++) {
			max = Math.max(max, price[i]);
			if(yd + price[i] > limit[i+1]) {
				count++;
				yd -= max - price[i];
				if(i < N-2 && yd + price[i+1] > limit[i+2]) i++;
			}else yd += price[i];
		}
		
		if(count > 1) System.out.println("Zzz");
		else System.out.println("Kkeo-eok");
	}
}

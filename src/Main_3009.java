import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] countX = new int[1001];
		int[] countY = new int[1001];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			countX[Integer.parseInt(st.nextToken())]++;
			countY[Integer.parseInt(st.nextToken())]++;
		}
		int x = 0, y = 0;
		
		for (int i = 1; i <= 1000; i++) {
			if(x!=0 && y!=0) break;
			if(countX[i] == 1) x = i;
			if(countY[i] == 1) y = i;
		}
		System.out.println(x + " " + y);
	}
}

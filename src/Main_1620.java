import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> pocket = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			pocket.put(String.valueOf(i), tmp);
			pocket.put(tmp, String.valueOf(i));
		}
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			System.out.println(pocket.get(tmp));
		}
	}
}

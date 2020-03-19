import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				if(!map.containsKey(tmp[1]))
					map.put(tmp[1], 1);
				else {
					map.put(tmp[1],map.get(tmp[1])+1);
				}
			}
			long ans = 1;
			for (String string : map.keySet()) {
				ans *= map.get(string) + 1;
			}
			System.out.println(ans-1);
		}
	}
}

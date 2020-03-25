import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int count = 0;
		int idx = -1;
		System.out.print("<");
		while(true) {
			idx = (idx+K) % list.size();
			System.out.print(list.get(idx));
			list.remove(idx--);
			if(++count == N) break;
			System.out.print(", ");
		}
		System.out.println(">");
	}
}

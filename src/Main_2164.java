import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) 
			q.add(i);
		int ans = 0;
		if(N == 1) ans = 1;
		else {
			while(true) {
				q.poll();
				int cur = q.poll();
				if(q.isEmpty()) {
					ans = cur;
					break;
				}
				q.add(cur);
			}
		}
		System.out.println(ans);
		
	}
}

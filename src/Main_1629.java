import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {
	static int A,B,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(dfs(A,B));
	}
	private static long dfs(long n, long m) {
		if(m == 0) return 1;
		else {
			long tmp = dfs(n,m/2);
			long ret = (tmp%C * tmp%C)%C;
			if(m%2 == 0) return ret % C;
			else return (ret%C * n%C) % C;
		}
		
	}
}

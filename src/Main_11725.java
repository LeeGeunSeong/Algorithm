import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11725 {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		parents = new int[N];
		Arrays.fill(parents, -1);
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			union(s,e);
		}
		
		for (int i = 1; i < N; i++) {
			System.out.println(parents[i]+1);
		}
	}
	private static void union(int s, int e) {
		int aRoot = find(s);
		int bRoot = find(e);
		if(aRoot != bRoot) 
			parents[aRoot] = bRoot;
		
	}
	private static int find(int s) {
		if(parents[s] < 0) return s;
		return parents[s] = find(parents[s]);
	}
}

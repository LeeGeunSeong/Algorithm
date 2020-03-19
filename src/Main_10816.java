import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] card = new int[N];
		int size = 20000001;
		int[] count = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			count[Integer.parseInt(st.nextToken()) + 10000000]++;
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) 
			sb.append(count[Integer.parseInt(st.nextToken()) + 10000000] + " ");
		System.out.println(sb.toString());
	}
}

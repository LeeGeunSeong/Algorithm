import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] tree = new long[N];
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			tree[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(tree);
		long min = 1, max = tree[N-1];
		while(min<=max) {
			long mid = (min + max)/2;
			long sum = 0;
			for (int i = 0; i < N; i++) 
				if(tree[i] > mid) sum += tree[i] - mid;
			if(sum < M) {
				max = mid - 1;
			}else
				min = mid + 1;
		}
		System.out.println(max);
	}
}

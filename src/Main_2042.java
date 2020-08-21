import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2042 {
	static long[] tree, num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 변경 횟수
		int K = Integer.parseInt(st.nextToken()); // 구간합 횟수
		
		num = new long[N];
		for (int i = 0; i < N; i++) 
			num[i] = Integer.parseInt(br.readLine());
		tree = new long[(int) Math.pow(2, (Math.ceil(Math.log10(N)/Math.log10(2))))*2];
		init(0,N-1,1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1) { // b번째 수를 c로
				update(0,N-1,1,b-1,c-num[b-1]);
				num[b-1] = c;
			}else { // b~c 합
				sb.append(sum(0,N-1,1,b-1,c-1)+"\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static long sum(int s, int e, int node, int l, int r) {
		if(l > e || r < s) return 0;
		
		if(l <= s && e <= r) return tree[node];
		
		int m = (s+e)/2;
		
		return sum(s,m,node*2,l,r) + sum(m+1,e,node*2+1,l,r);
	}

	private static void update(int s, int e, int node, int idx, long diff) {
		if(idx < s || idx > e) return;
		tree[node] += diff;
		if(s==e) return;
		int m = (s+e)/2;
		
		update(s, m, node*2, idx, diff);
		update(m+1, e, node*2+1, idx, diff);
	}

	private static long init(int s, int e, int node) {
		if(s==e) return tree[node] = num[s];
		int m = (s+e)/2;
		return tree[node] = init(s, m, node*2) + init(m+1, e, node*2+1);
	}
}

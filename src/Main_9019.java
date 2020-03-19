import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {
	static class DSLR{
		int val;
		String str;
		public DSLR(int val, String str) {
			super();
			this.val = val;
			this.str = str;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		boolean[] v = new boolean[10000];
		StringBuilder sb = new StringBuilder();
		Queue<DSLR> q = new LinkedList<>();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			Arrays.fill(v, false);
			q.clear();
			q.offer(new DSLR(start, ""));
			v[start] = true;
			
			while(!q.isEmpty()) {
				DSLR cur = q.poll();
				int val = cur.val;
				String str = cur.str;
				if(val == end) {
					sb.append(str);
					break;
				}
				//D
				int next = (val*2)%10000;
				if(!v[next]) {
					q.offer(new DSLR(next, str+"D"));
					v[next] = true;
				}
				//S
				next = val==0?9999:val-1;
				if(!v[next]) {
					q.offer(new DSLR(next, str+"S"));
					v[next] = true;
				}
				//L
				int add = val/1000;
				next = val - add*1000;
				next = next*10 + add;
				if(!v[next]) {
					q.offer(new DSLR(next, str+"L"));
					v[next] = true;
				}
				//R
				add = val%10;
				next = val/10;
				next += add*1000;
				if(!v[next]) {
					q.offer(new DSLR(next, str+"R"));
					v[next] = true;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

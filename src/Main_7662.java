import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_7662 {
	static class AA{
		int idx;
		long value;
		public AA(int idx, long value) {
			super();
			this.idx = idx;
			this.value = value;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			PriorityQueue<AA> q = new PriorityQueue<>(new Comparator<AA>() {
				@Override
				public int compare(AA o1, AA o2) {
					return o1.value>o2.value?1:-1;
				}
			});
			PriorityQueue<AA> q2 = new PriorityQueue<>(new Comparator<AA>() {
				@Override
				public int compare(AA o1, AA o2) {
					return o1.value<o2.value?1:-1;
				}
			});
			int N = Integer.parseInt(br.readLine());
			boolean[] v = new boolean[N];
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				
				long num = Integer.parseInt(tmp[1]);
				if(tmp[0].charAt(0) == 'I') {
					q.add(new AA(i,num));
					q2.add(new AA(i,num));
				}else {
					if(!q.isEmpty() && num == -1) {
						AA cur = q.peek();
						if(!v[cur.idx]) {
							q.poll();
							v[cur.idx] = true;
						}
					}
					else if(!q2.isEmpty() && num == 1){
						AA cur = q2.peek();
						if(!v[cur.idx]) {
							q2.poll();
							v[cur.idx] = true;
						}
					}
				}
				while(!q.isEmpty()) {
					if(!v[q.peek().idx]) break;
					else q.poll();
				}
				while(!q2.isEmpty()) {
					if(!v[q2.peek().idx]) break;
					else q2.poll();
				}
			}
			if(q.isEmpty() || q2.isEmpty()) sb.append("EMPTY\n");
			else sb.append(q2.poll().value + " " + q.poll().value).append("\n");
		}
		System.out.println(sb.toString());
	}
}

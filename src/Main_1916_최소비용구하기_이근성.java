import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기_이근성 {
	static int ans;
	static class Bus implements Comparable<Bus>{
		int b;
		long val;

		public Bus(int b, long dist) {
			super();
			this.b = b;
			this.val = dist;
		}

		@Override
		public int compareTo(Bus o) {
			return Long.compare(this.val, o.val);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ans = 0;
		int[][] arr = new int[N+1][N+1];
		long[] dist = new long[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < N+1; i++) {
			Arrays.fill(arr[i], -1);
		}
		boolean[] visited = new boolean[N+1];
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			if(arr[x][y] == -1) arr[x][y] = val;
			else if(arr[x][y] > val) arr[x][y] = val;
		}// end input
		st = new StringTokenizer(br.readLine());
		int begin = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Queue<Bus> queue = new PriorityQueue<>();
		dist[begin] = 0;
		queue.offer(new Bus(begin, dist[begin]));
		
		while(!queue.isEmpty()) {
			Bus tmp = queue.poll();
			if(visited[tmp.b]) continue;
			visited[tmp.b] = true;
			if(tmp.b == end) break;
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && arr[tmp.b][i] != -1
						&& tmp.val + arr[tmp.b][i] < dist[i]){
					dist[i] = tmp.val +arr[tmp.b][i];
					queue.offer(new Bus(i, dist[i]));
				}
			}
		}
		System.out.println(dist[end]);
	}// end main
}

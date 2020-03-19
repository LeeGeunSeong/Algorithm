import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 1000000000;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		q.add(new int[] {N,0});
		int[] v = new int[100001];
		Arrays.fill(v, 1000000);
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] < K) {
				if(cur[0]*2 < v.length && v[cur[0]*2] > cur[1]) {
					q.add(new int[] {cur[0]*2,cur[1]});
					v[cur[0]*2] = cur[1];
				}
				if(cur[0]-1 >= 0 && v[cur[0]-1] > cur[1]+1) {
					q.add(new int[] {cur[0]-1,cur[1]+1});
					v[cur[0]-1] = cur[1]+1;
				}
				if(cur[0]+1 < v.length && v[cur[0]+1] > cur[1]+1) {
					q.add(new int[] {cur[0]+1,cur[1]+1});
					v[cur[0]+1] = cur[1]+1;
				}
			}else if(cur[0] > K){
				if(cur[0]-1 >= 0 && v[cur[0]-1] > cur[1]+1) {
					q.add(new int[] {cur[0]-1,cur[1]+1});
					v[cur[0]-1] = cur[1]+1;
				}
			}else {
				ans = cur[1];
				break;
			}
		}
		System.out.println(ans);
	}
}

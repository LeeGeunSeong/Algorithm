import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_13913 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 1000000000;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N,0});
		boolean[] v = new boolean[200001];
		int[] parent = new int[200001];
		Stack<Integer> stack = new Stack<>();
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] < K) {
				if(cur[0]+1 < v.length && !v[cur[0]+1]) {
					q.add(new int[] {cur[0]+1,cur[1]+1});
					v[cur[0]+1] = true;
					parent[cur[0]+1] = cur[0];
				}
				if(cur[0]*2 < v.length && !v[cur[0]*2]) {
					q.add(new int[] {cur[0]*2,cur[1]+1});
					v[cur[0]*2] = true;
					parent[cur[0]*2] = cur[0];
				}
				if(cur[0]-1 >= 0 && !v[cur[0]-1]) {
					q.add(new int[] {cur[0]-1,cur[1]+1});
					v[cur[0]-1] = true;
					parent[cur[0]-1] = cur[0];
				}
			}else if(cur[0] > K){
				if(cur[0]-1 >= 0 && !v[cur[0]-1]) {
					q.add(new int[] {cur[0]-1,cur[1]+1});
					v[cur[0]-1] = true;
					parent[cur[0]-1] = cur[0];
				}
			}else {
				ans = cur[1];
				int idx = cur[0];
				while(true) {
					stack.push(idx);
					if(idx == N) break;
					idx = parent[idx];
				}
				break;
			}
		}
		System.out.println(ans);
		while(!stack.isEmpty()) System.out.print(stack.pop() + " ");
	}
}

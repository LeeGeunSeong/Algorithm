import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6118_숨바꼭질_이근성_BFS {
	static class Node{
		int next, dist;

		public Node(int next, int dist) {
			super();
			this.next = next;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List[] list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 0));
		visited[1] = true;
		int num = 0; // 헛간 번호
		int maxDist = 0; // 거리
		int count = 1; // 개수
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int idx = cur.next;
			int dist = cur.dist;
			
			if(dist > maxDist) {
				maxDist = dist;
				count = 1;
				num = idx;
			}else if(dist == maxDist) {
				count++;
				num = Math.min(idx, num);
			}
			for (int i = 0; i < list[idx].size(); i++) {
				int next = (int) list[idx].get(i);
				if(visited[next]) continue;
				queue.offer(new Node(next, dist+1));
				visited[next] = true;
			} 
		}
		System.out.println(num + " " + maxDist + " " + count);
	}
}

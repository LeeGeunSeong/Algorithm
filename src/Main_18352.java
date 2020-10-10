import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시 개수
		int M = Integer.parseInt(st.nextToken()); // 도로 개수
		int K = Integer.parseInt(st.nextToken()); // 거리 정보
		int X = Integer.parseInt(st.nextToken()); // 도시 번호
		
		List<Integer>[] listArray = new ArrayList[N+1];
		for (int i = 0; i < listArray.length; i++) 
			listArray[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			listArray[s].add(e);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> (o1[1]-o2[1]));
		boolean[] v = new boolean[N+1];
		pq.offer(new int[] {X,0});
		v[X] = true;
		List<Integer> ans = new ArrayList<>();
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int pos = cur[0];
			int val = cur[1];
			if(val == K) {
				ans.add(pos);
				continue;
			}
			for (int i = 0; i < listArray[pos].size(); i++) {
				int next = listArray[pos].get(i);
				if(v[next]) continue;
				pq.offer(new int[] {next, val+1});
				v[next] = true;
			}
		}
		Collections.sort(ans);
		if(ans.size() == 0) System.out.println(-1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.size(); i++)
			sb.append(ans.get(i) + "\n");
		System.out.println(sb.toString());
	}
}

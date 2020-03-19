import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> q = new LinkedList<>();
			List<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.add(new int[] {num,i});
				list.add(num);
			}
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			int cnt = 0, idx = 0;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				if(list.get(idx)!=cur[0]) { 
					q.add(new int[] {cur[0],cur[1]});
					continue;
				}else {
					cnt++;
					idx++;
				}
				if(cur[1] == M) {
					System.out.println(cnt);
					break;
				}
			}
		}
	}
}

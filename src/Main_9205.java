import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int[][] point = new int[N+2][2];
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			int[] dest = point[N+1];
			boolean isArrive = false;
			Queue<int[]> q = new LinkedList<>();
			boolean[] v = new boolean[N+2];
			q.offer(new int[] {point[0][0],point[0][1],0});
			v[0] = true;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				if(cur[0] == dest[0] && cur[1] == dest[1]) {
					isArrive = true;
					break;
				}
				for (int i = 0; i < N+2; i++) {
					if(i==cur[2] 
							|| Math.abs(point[i][0]-cur[0])+Math.abs(point[i][1]-cur[1]) > 1000) 
						continue;
					if(v[i]) continue;
					q.offer(new int[] {point[i][0],point[i][1],i});
					v[i] = true;
				}
			}
			if(isArrive) System.out.println("happy");
			else System.out.println("sad");
		}
	}
}

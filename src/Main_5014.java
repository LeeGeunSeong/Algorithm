import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		boolean[] v = new boolean[F+1];
		q.offer(new int[] {S,0});
		v[S] = true;
		int ans = -1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == G) {
				ans = cur[1];
				break;
			}
			if(cur[0]+U <= F && !v[cur[0]+U]) {
				q.offer(new int[] {cur[0]+U,cur[1]+1});
				v[cur[0]+U] = true;
			}
			if(cur[0]-D > 0 && !v[cur[0]-D]) {
				q.offer(new int[] {cur[0]-D,cur[1]+1});
				v[cur[0]-D] = true;
			}
		}
		if(ans==-1) System.out.println("use the stairs");
		else System.out.println(ans);
	}
}


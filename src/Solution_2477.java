import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2477 {
	static int N,M,K,A,B;
	static int[][] abc;
	static boolean[][] abcCheck;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			abc = new int[3][];
			abc[0] = new int[N];
			abc[1] = new int[M];
			abc[2] = new int[K];
			
			abcCheck = new boolean[2][];
			abcCheck[0] = new boolean[N];
			abcCheck[1] = new boolean[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) abc[0][i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) abc[1][i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) abc[2][i] = Integer.parseInt(st.nextToken());
			
			int time = 0, ans = 0 , size = 0;
			
			Queue<int[]> aq = new LinkedList<>();
			PriorityQueue<int[]> bq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return	o1[5]-o2[5]==0?o1[2]-o2[2]==0?
							o1[3]-o2[3]:o1[2]-o2[2]:o1[5]-o2[5];
				}
			});
			int cnt = 0;
			while(true) {
				while(cnt < K && time == abc[2][cnt]) {
					int[] tmp = new int[] {cnt,abc[2][cnt],abc[2][cnt++],0,0,0};
					// 번호, 들어온 시간, 나가는 시간, 이용한 창구 번호
					aq.offer(tmp);
				}
				int aLen = aq.size();
				while(aLen-- > 0){
					int[] cur = aq.poll();
					if(cur[3] == 0) {
						int i = 0;
						for (i = 0; i < N; i++) 
							if(!abcCheck[0][i]) {
								abcCheck[0][i] = true;
								cur[3] = i+1;
								cur[1] = time;
								break;
							}
					}
						
					if(cur[3] > 0 && time == abc[0][cur[3]-1] + cur[1]) {
						cur[2] = time;
						cur[5] = time;
						bq.offer(cur);
						abcCheck[0][cur[3]-1] = false;
						continue;
					}
					aq.offer(cur);
				}
				int bLen = bq.size();
				while(bLen-- > 0) {
					int[] cur = bq.poll();
					if(cur[4] == 0) {
						int i = 0;
						for (i = 0; i < M; i++) 
							if(!abcCheck[1][i]) {
								abcCheck[1][i] = true;
								cur[4] = i+1;
								cur[1] = time;
								break;
							}
					}
					
					if(cur[4] > 0 && time == abc[1][cur[4]-1] + cur[1]) {
						size++;
						if(cur[3] == A && cur[4] == B) ans += cur[0] + 1;
						abcCheck[1][cur[4]-1] = false;
						continue;
					}
					cur[5]++;
					bq.offer(cur);
					
				}
				if(size == K) break;
				time++; // 시간 증가
			}
			
			System.out.println("#" + tc + " " + (ans==0?-1:ans));
		}
	}
}

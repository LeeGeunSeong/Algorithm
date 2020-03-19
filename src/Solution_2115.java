import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_2115 {
	static int N,M,C,ans,s;
	static int[][] map,worker;
	static int[] arr;
	static boolean f;
	static boolean[] flag;
	static boolean[][] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N][N];
			check = new boolean[N][N];
			arr = new int[N];
			worker = new int[2][2];
			flag = new boolean[2];
			// 0 : 선택할 수 있는 벌통 개수, 1 : 최대 수집할 수 있는 벌꿀의 양
			worker[0][0] = worker[1][0] = M;
			worker[0][1] = worker[1][1] = C;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) { 
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// end input
			gathering(0,0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void gathering(int start, int sum) {
		if(flag[0] && flag[1]) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = start; i < N; i++) {
			outer:
			for (int j = 0; j <= N-M; j++) {
				if(check[i][j]) continue;
				int idx = j;
				int[] tmp = new int[2];
				f = false;
				s = 0;
				
				if(!flag[0]) { 
					flag[0] = true;
					tmp[0] = worker[0][0];
					tmp[1] = worker[0][1];
					while(idx < N && worker[0][0]-- > 0) {
						if(check[i][idx]) {
							flag[0] = false;
							worker[0][0] = tmp[0];
							for (int k = idx-1; k >= j; k--) check[i][k] = false;
							continue outer; 
						}
						check[i][idx++] = true;
					}
					sum(tmp,i,j,idx,0,0);
					gathering(i,sum+s);
					worker[0][0] = tmp[0];
					for (int k = idx-1; k >= j; k--) check[i][k] = false;
					flag[0] = false;
				}
				else if(!flag[1]) { 
					flag[1] = true;
					tmp[0] = worker[1][0];
					tmp[1] = worker[1][1];
					while(idx < N && worker[1][0]-- > 0) {
						if(check[i][idx]) {
							flag[1] = false;
							worker[1][0] = tmp[0];
							for (int k = idx-1; k >= j; k--) check[i][k] = false;
							continue outer;
						}
						check[i][idx++] = true;
					}
					sum(tmp,i,j,idx,0,0);
					gathering(i,sum+s);
					worker[1][0] = tmp[0];
					for (int k = idx-1; k >= j; k--) check[i][k] = false;
					flag[1] = false;
				}
				else gathering(i,sum);
			}
		}
	}
	private static void sum(int[] tmp, int h,int start, int end, int cnt, int sum) {
		if((cnt == M || tmp[0] == 0)
				|| start == end) {
			s = Math.max(sum, s);
			return ;
		}
		for (int i = start; i < end; i++) {
			tmp[0]--;
			tmp[1] -= map[h][i];
			if(tmp[1] < 0) {
				sum(tmp,h,i+1,end,cnt+1,sum);
			}else {
				sum(tmp,h,i+1,end,cnt+1,sum+map[h][i]*map[h][i]);
			}
			tmp[0]++;
			tmp[1] += map[h][i];
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;



//////////////////////////////////
// 			우선순위 큐				//
//////////////////////////////////
public class Main_1916_최소비용구하기 {
	static int N,M,begin,end,minCost,maxCost;
	static int[][] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
			N = Integer.parseInt(br.readLine()); //도시
			M = Integer.parseInt(br.readLine());
			StringTokenizer st;
			tmp = new int[N+1][N+1];
			for (int i = 0; i < N+1; i++) {
				for (int j = 0; j < N+1; j++) {
					tmp[i][j] = Integer.MAX_VALUE;
				}
			}
			maxCost = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				if(tmp[a][b] > value) {
					maxCost = Math.max(maxCost, value);
					tmp[a][b] = value;
				}
			}
			st = new StringTokenizer(br.readLine());
			begin = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			// end input
			
			minCost = Integer.MAX_VALUE;
			
			dfs(begin, end, 0);
			System.out.println(minCost);
	}//end main
	private static void dfs(int start, int dest, int cost) {
		for (int i = 1; i < tmp.length; i++) {
			if(tmp[start][i] <= maxCost) {
				if(i == dest) {
					minCost = Math.min(minCost, cost+tmp[start][i]);
					return;
				}
//				if(cost+tmp[start][i] > minCost) return;
				
				dfs(i,dest,cost+tmp[start][i]);
			}
		}
	}
	
	
}
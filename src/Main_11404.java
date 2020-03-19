import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404 {
	static int N,M;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		int INF = 1000000000;
		for (int i = 0; i < N; i++) 
			Arrays.fill(map[i], INF);
		
		StringTokenizer st;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			
			map[from][to] = Math.min(map[from][to], val);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				for (int k = 0; k < N; k++) {
					if(i == k || j == k) continue;
					if(map[j][i] + map[i][k] < map[j][k]) 
						map[j][k] = map[i][k] + map[j][i];
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == INF) map[i][j] = 0;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(adj[i], 10000000);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		int ans = 101;
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i==k) continue;					
				for (int j = 0; j < N; j++) {
					if(i==j||j==k) continue;
					if(adj[i][j] > adj[i][k] + adj[k][j]) 
						adj[i][j] = adj[i][k] + adj[k][j];
				}
			}
		}
		int min = 10000000;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) 
				if(adj[i][j] < 10000000) cnt += adj[i][j];
			if(cnt < min) {
				min = cnt;
				ans = i+1;
			}
		}
		System.out.println(ans);
	}
}

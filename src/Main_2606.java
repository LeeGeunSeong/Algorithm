import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2606 {
	static int N,M,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i][j] = 10000000;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			adj[u][v] = 1;
			adj[v][u] = 1;
		}
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
		for (int i = 0; i < N; i++) 
			if(adj[0][i] < 10000000) ans++;
		
		System.out.println(ans);
	}
}

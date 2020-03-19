import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] adj = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(adj[i], 100000);
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			adj[x][y] = 1;
		}
		for (int k = 0; k < adj.length; k++) {
			for (int i = 0; i < adj.length; i++) {
				if(i==k) continue;
				for (int j = 0; j < adj.length; j++) {
					if(i==j || j==k) continue;
					if(adj[i][j] > adj[i][k] + adj[k][j])
						adj[i][j] = adj[i][k] + adj[k][j];
				}
			}
		}
		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			if(adj[x][y] == 100000 && adj[y][x] == 100000) System.out.println(0);
			else if(adj[x][y] != 100000) System.out.println(-1);
			else if(adj[x][y] == 100000 && adj[y][x] != 100000) System.out.println(1);
		}
	}
}

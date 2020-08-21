import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		
		int M = Integer.parseInt(br.readLine());
		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(adj[i], 100);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1; // 부모
			int y = Integer.parseInt(st.nextToken())-1; // 자식
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i==k) continue;
				for (int j = 0; j < N; j++) {
					if(j==k) continue;
					adj[i][j] = Math.min(adj[i][k] + adj[k][j], adj[i][j]);
				}
			}
		}
		System.out.println(adj[a][b]==100?-1:adj[a][b]);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		StringTokenizer st;
		int INF = 1000000;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				if(map[i][j] == 0) map[i][j] = INF;
		
		for (int k = 0; k < N; k++) 
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++) 
					if(map[i][j] > map[i][k] + map[k][j]) 
						map[i][j] = map[i][k] + map[k][j];
		
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				if(map[i][j] < INF) map[i][j] = 1;
				else if(map[i][j] == INF) map[i][j] = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}

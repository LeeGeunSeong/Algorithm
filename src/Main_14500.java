import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {
	static int N,M,ans;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i,j,0,0); // ㅜ모양을 제외한 나머지
				rem(i,j);
			}
		}
		System.out.println(ans);
	}
	private static void rem(int i, int j) {
		int sum=0;
		if(i < N-1 && j < M-2) { // ㅜ
			sum += map[i][j];
			sum += map[i][j+1];
			sum += map[i][j+2];
			sum += map[i+1][j+1];
			ans = Math.max(ans, sum);
		}
		if(i < N-2 && j < M-1) { // ㅓ
			sum=0; 
			sum += map[i][j+1];
			sum += map[i+1][j+1];
			sum += map[i+2][j+1];
			sum += map[i+1][j]; 
			ans = Math.max(ans, sum);
		}
		if(i < N-1 && j < M-2) { // ㅗ
			sum=0; 
			sum += map[i+1][j];
			sum += map[i+1][j+1]; 
			sum += map[i+1][j+2];
			sum += map[i][j+1];
			ans = Math.max(ans, sum);
		}
		if(i < N-2 && j < M-1) { // ㅏ
			sum=0; 
			sum += map[i][j];
			sum += map[i+1][j];
			sum += map[i+2][j];
			sum += map[i+1][j+1];
			ans = Math.max(ans, sum);
		}
	}
	static int[] dx = {-1,1,0,0}; 
	static int[] dy = {0,0,-1,1}; 
	private static void dfs(int i, int j, int cnt, int sum) {
		if(cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int dir = 0; dir < 4; dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M
						|| v[nx][ny]) continue;
			
			v[nx][ny] = true;
			dfs(nx,ny,cnt+1,sum+map[nx][ny]);
			v[nx][ny] = false;
		}
		
	}
}

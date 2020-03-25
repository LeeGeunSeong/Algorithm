import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2667_dfs {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Integer> ans;
	static int N,ret;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
		// end input
		
		// dfs
		v = new boolean[N][N];
		ans = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 || v[i][j]) continue;
				ret = 1;
				v[i][j] = true;
				dfs(i,j);
				ans.add(ret);
			}
		}
		System.out.println("--------------------------------------");
		System.out.println("DFS 결과");
		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) 
			System.out.println(ans.get(i));
		System.out.println("--------------------------------------");
		
	}
	private static void dfs(int i, int j) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];
			
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1
					|| v[nx][ny] || map[nx][ny] == 0) continue;
			
			v[nx][ny] = true;
			dfs(nx,ny);
			ret++;
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집_이근성 {
	static int[] dx = {-1,0,1};	
	static char[][] map;
	static int R,C,ans;
	static boolean isArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];	
		ans = 0;
		for (int i = 0; i < R; i++) 
			map[i] = br.readLine().toCharArray();
		// end input
		for (int i = 0; i < R; i++) {
			isArr = false;
			map[i][0] = 'p';
			dfs(0,i);
		}
		System.out.println(ans);
	}
	private static void dfs(int idx, int i) {
		if(idx == C-2) {
			ans++;
			map[i][idx] = 'x';
			isArr = true;
			return;
		}
		map[i][idx] = 'p';
		for (int j = 0; j < 3; j++) {
			int nx = i + dx[j];
			int ny = idx + 1;
			if(nx < 0 || nx > R-1
					|| map[nx][ny] != '.') continue;
			dfs(idx+1,nx);
			
			if(isArr) return;
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1987_알파벳_이근성 {
	static char[][] board;
	static int R,C,ans,tmp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] alpha;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		alpha = new int[26];
		for (int i = 0; i < R; i++) 
			board[i] = br.readLine().toCharArray();
		// end input
		
		ans = 1;
		tmp = 1;
		alpha[board[0][0]-'A']++;
		dfs(0,0);
		System.out.println(ans);
	}// end main
	private static void dfs(int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C
					|| alpha[board[nx][ny]-'A'] > 0) continue;
			alpha[board[nx][ny]-'A']++;
			ans = Math.max(++tmp, ans);
			dfs(nx,ny);
			alpha[board[nx][ny]-'A']--;
			tmp--;
		}
	}
}

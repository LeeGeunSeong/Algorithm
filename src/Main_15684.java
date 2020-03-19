import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15684 {
	static int N,M,H,ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 가로 길이
		M = Integer.parseInt(st.nextToken()); // 가로선 개수
		H = Integer.parseInt(st.nextToken()); // 세로 길이
		
		map = new int[H+1][N+1];
		ans = 5;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		dfs(1,1,0);
		
		System.out.println(ans==5?-1:ans);
	}
	private static void dfs(int x, int y, int idx) {
		if(idx > 3) return;
		for (int i = y<N?x:x+1; i <= H ; i++) {
			for (int j = 1; j < N; j++) {
				if(!check(i,j)) continue;
				map[i][j] = 1;
				dfs(i,j,idx+1);
				map[i][j] = 0;
			}
			if(i == H && check()) ans = Math.min(ans, idx);
		}
	}
	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			int height = 1;
			int dest = i;
			while(height <= H) {
				if(map[height][dest] == 1) dest++;
				else if(map[height][dest-1] == 1) dest--;
				height++;
			}
			if(dest != i) return false;
		}
		return true;
	}
	private static boolean check(int x, int y) {
		if(map[x][y-1] == 1 || map[x][y] == 1 || map[x][y+1] == 1) return false;
		return true;
	}
}

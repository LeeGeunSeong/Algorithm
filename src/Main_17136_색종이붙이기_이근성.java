import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기_이근성 {
	static int N = 10,ans,ret;
	static int[][] map;

	static class pair {
		int x, y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean isWrong;
	static int[] coverPaper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		map = new int[N][N];
		coverPaper = new int[6];
		for (int i = 1; i <= 5; i++) {
			Arrays.fill(coverPaper, 5);
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		ans = 0;
		ret = Integer.MAX_VALUE;
		if(!isEnd()) {
			dfs(0,0);
			ans = ret;
			if(ans == Integer.MAX_VALUE) ans = -1;
		}
		else ans = 0;
		
		System.out.println(ans);
	}
	private static void dfs(int idx, int num) {
		if(num >= ret) return;
		if(isEnd()) {
			ret = Math.min(num, ret);
			return;
		}
		for (int i = idx; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					boolean flag = false;
					for (int k = 5; k >= 1; k--) {
						if(i+k > N || j+k > N || coverPaper[k] < 1) continue;
						 
						if(!flag) flag = isCover(i, j, k);
						if (flag) {
							coverPaper[k]--;
							for (int l = i; l < i+k; l++) 
								for (int l2 = j; l2 < j+k; l2++) 
									map[l][l2] ^= 1;
							dfs(i,num+1);
							coverPaper[k]++;
							for (int l = i; l < i+k; l++) 
								for (int l2 = j; l2 < j+k; l2++) 
									map[l][l2] ^= 1;
						}
					}
				}
				if(map[i][j] == 1) return;
			}
		}
	}
	private static boolean isEnd() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) return false;
			}
		}
		return true;
	}
	private static boolean isCover(int i, int j, int cnt) {
		for (int k = i; k < i+cnt; k++) 
			for (int l = j; l < j+cnt; l++) 
				if(map[k][l] == 0) return false;
		return true;
	}
}
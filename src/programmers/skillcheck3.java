package programmers;

import java.util.Arrays;

public class skillcheck3 {
	public static void main(String[] args) {
		String input = "";
		int N = 5;
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}; // A > B
		System.out.println(solution(key, lock));
	}
	// 고고학자 튜브
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        for (int i = 0; i < 4; i++) {
			if(check(key,lock)) return true;
        	key = rotateKey(key);
		}
        return answer;
    }

	private static boolean check(int[][] key, int[][] lock) {
		for (int i = 1-key.length; i < lock.length; i++) {
			for (int j = 1-key.length; j < lock.length; j++) {
				int[][] tmp = move(key,lock.length,i,j);
				if(isUnlock(tmp,lock)) return true;
				
			}
		}
		return false;
	}

	private static boolean isUnlock(int[][] key, int[][] lock) {
		for (int i = 0; i < lock.length; i++) 
			for (int j = 0; j < lock.length; j++) 
				if(key[i][j]+lock[i][j] != 1) return false;
		return true;
	}

	private static int[][] move(int[][] key, int len, int r, int c) {
		int[][] tmp = new int[len][len];
		int keyLen = key.length;
		for (int i = 0; i < keyLen; i++) {
			for (int j = 0; j < keyLen; j++) {
				if(i+r < 0 || i+r >= len || j+ c < 0 || j+c >=len) continue;
				tmp[i+r][j+c] = key[i][j];
			}
		}
		return tmp;
	}

	private static int[][] rotateKey(int[][] key) {
		int[][] tmp = new int[key.length][key.length];
		for (int i = 0; i < key.length; i++) 
			for (int j = 0; j < key.length; j++) 
				tmp[i][j] = key[key.length-1-j][i];
		return tmp;
	}
	// 순위
	private static int solution(int n, int[][] res) {
		int ans = 0, INF = 1000000000;
		int[][] rank = new int[n+1][n+1];
		
		for (int i = 0; i <= n; i++) 
			Arrays.fill(rank[i], INF);
		
		for (int i = 0; i < res.length; i++) 
			rank[res[i][0]][res[i][1]] = 1;
		for (int i = 0; i <= n ; i++) 
			rank[i][i] = 0;
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(rank[i][j] > rank[i][k] + rank[k][j])
						rank[i][j] = rank[i][k] + rank[k][j];
				}
			}
		}
		boolean[] flag = new boolean[n+1];
		Arrays.fill(flag, true);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i==j) continue;
				if(rank[i][j]==INF&&rank[j][i]==INF) {
					flag[i] = false;
					break;
				}
			}
		}
		for (int i = 1; i <= n; i++) 
			if(flag[i]) ans++;
		
		return ans;
	}
}

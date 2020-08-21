package toss1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution6 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] tmp = input.split(";");
		int N = tmp.length;
		int M = tmp[0].split(" ").length;
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmpArr = tmp[i].split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmpArr[j]);
			}
		}
		int answer = 0;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					
					if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1
							|| map[nx][ny] == 1) continue;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14499 {
	static int N,M,x,y,K;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[] dice;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dice = new int[6];
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int order = Integer.parseInt(st.nextToken()) - 1;
			
			x += dx[order];
			y += dy[order];
			
			if(x < 0 || x >= N || y < 0 || y >= M) {
				x -= dx[order];	y -= dy[order];
				continue;
			}
			int[] tmp = dice.clone();
			switch (order) {
			case 0:
				dice[0] = tmp[3];
				dice[2] = tmp[0];
				dice[3] = tmp[5];
				dice[5] = tmp[2];
				break;
			case 1:
				dice[0] = tmp[2];
				dice[2] = tmp[5];
				dice[3] = tmp[0];
				dice[5] = tmp[3];
				break;
			case 2:
				dice[0] = tmp[4];
				dice[1] = tmp[0];
				dice[4] = tmp[5];
				dice[5] = tmp[1];
				break;
			case 3:
				dice[0] = tmp[1];
				dice[1] = tmp[5];
				dice[4] = tmp[0];
				dice[5] = tmp[4];
				break;

			default:
				break;
			}
			if(map[x][y] == 0) map[x][y] = dice[5];
			else {
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			
			System.out.println(dice[0]);
		}
		
	}

}

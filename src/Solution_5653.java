import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5653 {
	static int ans,N,M,K;
	static int[][] map,dead,now;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		map = new int[650][650];
		now = new int[650][650];
		dead = new int[650][650];
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = 0;
			for (int i = 0; i < 650; i++) { 
				Arrays.fill(map[i], 0);
				Arrays.fill(now[i], 0);
				Arrays.fill(dead[i], -1);
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) 
					// K <= 300 이니까 초기 위치는 (300,300) 
					map[300+i][300+j] = Integer.parseInt(st.nextToken());
			}
			// K초 동안의 변화
			for (int time = 2; time <= K; time++) {
				//map[i][j]에 있는 값부터 시작해서
				//map[i][j]에 있는 값만큼 활성화
				//그 다음엔 죽어
				spread(time);
			}
			checkAlive();
			System.out.println("#" + tc + " " + ans);
		}// end tc
	}// end main
	
	// K시간 후 살아있는 세포 찾기
	private static void checkAlive() {
		for (int i = 300-K; i < 350 + K; i++) 
			for (int j = 300-K; j < 350 + K; j++) 
				if(map[i][j] > 0 && dead[i][j] == -1) ans++;
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static void spread(int time) {
		for (int i = 300 - time; i < 350 + time; i++) {
			for (int j = 300 - time; j < 350 + time; j++) {
				if(map[i][j] == 0 || dead[i][j] == 0) continue;
				// 번식
				if(time%(map[i][j]+1) == 0) {
					for (int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						
						if(map[nx][ny] > 0 || dead[nx][ny] > -1) continue;
						if(now[nx][ny] < map[i][j]) 
							now[nx][ny] = map[i][j];
					}
					dead[i][j] = 0;
				}
			}
		}
		for (int i = 300 - time; i < 350 + time; i++) {
			for (int j = 300 - time; j < 350 + time; j++) {
				if(map[i][j] == 0) map[i][j] = now[i][j];
				now[i][j] = 0;
			}
		}
	}
}
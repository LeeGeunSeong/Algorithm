import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17780_새로운게임_이근성 {
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 체스판 크기
		int K = Integer.parseInt(st.nextToken()); // 말의 개수
		int[][] piece = new int[K][3]; // 말의 정보
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 1 : 빨, 2 : 파
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] cntMap = new int[N][N];
		int[][][] idxMap = new int[N][N][K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			piece[i][0] = x; piece[i][1] = y;
			piece[i][2] = Integer.parseInt(st.nextToken());
			cntMap[x][y]++;
			idxMap[x][y][0] = i+1;
		}
		// 1 : 우, 2 : 좌, 3 : 상, 4 : 하
		int cnt = 0, sec = 0;
		while(cnt < 4) {
			// 이동
			if(sec++ > 1000) break;
			for (int i = 0; i < K; i++) {
				int[] tmp = piece[i];
				int x = tmp[0], y = tmp[1];
				// 가장 아래 말이 아니면 continue
				if(idxMap[x][y][0] != i+1) continue;
				int nx = x + dx[tmp[2]];
				int ny = y + dy[tmp[2]];
				// 방향 바꾸기
				if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1
						|| map[nx][ny] == 2) {
					if(tmp[2] % 2 == 0) tmp[2]--;
					else tmp[2]++;
					
					nx = x + dx[tmp[2]];
					ny = y + dy[tmp[2]];
					if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || map[nx][ny] == 2) continue;
				}
				// 위 아래 바꾸기
				int j = 0;
				if(map[nx][ny] == 1) {
					for (j = 0; j < K; j++) 
						if(idxMap[x][y][j] == 0) break;
					j--;
					int temp = idxMap[tmp[0]][tmp[1]][0]; 
					idxMap[x][y][0] = idxMap[x][y][j];
					idxMap[x][y][j] = temp;
				}
				// idx 이동
				for (j = 0; j < K; j++) 
					if(idxMap[nx][ny][j] == 0) break;
				for (int k = j; k < j + cntMap[x][y]; k++) {
					int temp = idxMap[x][y][k-j];
					idxMap[nx][ny][k] = temp;
					idxMap[x][y][k-j] = 0;
					
					piece[temp-1][0] = nx;
					piece[temp-1][1] = ny;
				}
				// cnt 이동
				cntMap[nx][ny] += cntMap[x][y];
				cntMap[x][y] = 0;
				tmp[0] = nx; tmp[1] = ny;
				cnt = Math.max(cnt, cntMap[nx][ny]);
			}
		}
		System.out.println(sec<=1000?sec:-1);
	}
}

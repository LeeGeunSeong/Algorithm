import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17143_낚시왕_이근성 {
	static int R, C, M, ans;
	static int r, c, s, d, z;
	static int[] arr;

	static class sanguh implements Comparable<sanguh> {
		int x, y;
		int speed, dir, z;

		public sanguh(int r, int c, int s, int d, int z) {
			super();
			this.x = r;
			this.y = c;
			this.speed = s;
			this.dir = d;
			this.z = z;
		}

		@Override
		public int compareTo(sanguh o) {
			return o.z - this.z;
		}
	}

	static int[][] map;
	static boolean[][] isRemove;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static List<sanguh> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		M = Integer.parseInt(st.nextToken()); // 상어 수

		ans = 0;
		map = new int[R+1][C+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()); // 상어 행
			c = Integer.parseInt(st.nextToken()); // 상어 열
			s = Integer.parseInt(st.nextToken()); // 속력
			d = Integer.parseInt(st.nextToken()); // 이동 방향
			z = Integer.parseInt(st.nextToken()); // 크기
			list.add(new sanguh(r, c, s, d-1, z));
			map[r][c] = z;
		} // end input
		isRemove = new boolean[R+1][C+1];
		int person = 0;
		//낚시왕 이동
		Collections.sort(list);
		while(++person <= C && !list.isEmpty()) {
			newMap();
			//상어 낚시
			for (int i = 1; i <= R; i++) {
				if(map[i][person] != 0) {
					ans += map[i][person];
					map[i][person] = 0;
					break;
				}
			}
			//상어 이동
			for (int i = 0; i < list.size(); i++) {
				sanguh s = list.get(i);
				if(map[s.x][s.y] == 0){
					list.remove(i--);
					continue;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				sanguh s = list.get(i);
				int x = s.x;
				int y = s.y;
				map[x][y] -= s.z;

				int tmpSpeed = s.speed;
				int nx = 0,ny = 0;
				
				while(true) {
					nx = x + dx[s.dir] * tmpSpeed;
					ny = y + dy[s.dir] * tmpSpeed;
					if(nx > 0 && ny > 0 && nx <= R && ny <= C) break;
					if(s.dir ==0 && nx <= 0) { 		// 상
						tmpSpeed -= x - 1;
						x = 1;
						s.dir = 1;
					}
					else if(s.dir ==1 && nx > R) {	// 하
						tmpSpeed -= R-x;
						x = R;
						s.dir = 0;
					}
					else if(s.dir ==2 && ny > C) { 	// 우
						tmpSpeed -= C-y;
						y = C;
						s.dir = 3;
					}
					else if(s.dir ==3 && ny <= 0) {	// 좌
						tmpSpeed -= y - 1;
						y = 1;
						s.dir = 2;
					}
				}
				s.x = nx;
				s.y = ny;
				map[nx][ny] += s.z;
			}
			//상어 잡아먹기
			for (int i = 0; i < list.size(); i++) {
				sanguh s = list.get(i);
				if(!isRemove[s.x][s.y] && map[s.x][s.y] != s.z) {
					isRemove[s.x][s.y] = true;
					map[s.x][s.y] = 0; 
				}else if(isRemove[s.x][s.y]){
					list.remove(i--);
				}
			}
		}
		System.out.println(ans);
	} // end main

	private static void newMap() {
		for (int i = 1; i <= R; i++) {
			Arrays.fill(isRemove[i], false);
		}
		for (int i = 0; i < list.size(); i++) {
			map[list.get(i).x][list.get(i).y] = list.get(i).z;
		}
	}
}
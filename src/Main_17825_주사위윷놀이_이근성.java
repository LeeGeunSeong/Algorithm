import java.io.IOException;
import java.util.Arrays;


public class Main_17825_주사위윷놀이_이근성 {
	static class Horse {
		int dist, dir;

		public Horse(int dist, int dir) {
			super();
			this.dist = dist;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Horse [dist=" + dist + ", dir=" + dir + "]";
		}
	}

	static int[][] map = { {}, { 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40, -1 },
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40, -1 },
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 29, 28, 27, 26, 25, 30, 35, 40, -1 },
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 29, 32, 34, 36, 38, 40, -1 } };
	static int[] change = { 0, 5, 10, 15 };
	static int[] end = { 0, 13, 17, 23, 21 }; // 끝 index
	static boolean[] finish;
	static int[] turn;
	static Horse[] list;
	static int result;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N, ret, ans, ans2;
	static int[] arr, print;
	static int[][] mal;
	static boolean fff;
	static boolean[] end2;
	static boolean[][] v;
	static int[][] map2 = { { 0 },
							{ 40, 38, 0, 36, 0, 34, 0, 32, 30 },
							{ 2, 0, 0, 0, 0, 0, 0, 28, 28 },
							{ 0, 0, 35, 0, 0, 0, 27, 0, 0 },
							{ 4, 0, 0, 30, 0, 26, 0, 0, 26 },
							{ 0, 0, 0, 0, 25, 0, 0, 0, 0 },
							{ 6, 0, 0, 19, 0, 24, 0, 0, 24 },
							{ 0, 0, 16, 0, 0, 0, 22, 0, 0 },
							{ 8, 13, 0, 0, 0, 0, 0, 0, 22 },
							{ 10, 12, 0, 14, 0, 16, 0, 18, 20 } }; // 9 by 9

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = 9;
		arr = new int[10];
		print = new int[10];
		v = new boolean[N + 1][N];
		end2 = new boolean[4];
		mal = new int[4][2];

		ans = 0;
		result = 0;
		turn = new int[10]; // 말 -4개
		finish = new boolean[5];
		list = new Horse[5];
		for (int i = 1; i <= 4; i++)
			list[i] = new Horse(0, 4);
		outer: while (true) {
			for (int i = 0; i < 10; i++)
				arr[i] = (int) (Math.random() * 5) + 1;

			dfs(0, 0);
			P(0, 0);
			if (ans != result) {
				System.out.println(Arrays.toString(arr));
				System.out.println(Arrays.toString(print));
				System.out.println(Arrays.toString(turn));
				System.out.println(ans + " " + result);
				break;
			}
			for (int i = 0; i < 10; i++) {
				if (print[i] != turn[i]) {
					System.out.println(Arrays.toString(arr));
					System.out.println(Arrays.toString(print));
					System.out.println(Arrays.toString(turn));
					System.out.println(ans + " " + result);
					break outer;
				}
			}
		}
	}

	private static void dfs(int cnt, int sum) {
		if (cnt == 10) {
			if (sum > ans) {
				ans = sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (end2[i])
				continue;
			int tx = mal[i][0];
			int ty = mal[i][1];
			fff = false;
			if (!isMove(i, arr[cnt]))
				continue;
			print[cnt] = i + 1;
			boolean f = fff;
			v[tx][ty] = false;
			dfs(cnt + 1, sum + ret);
			v[tx][ty] = true;
			if (f)
				end2[i] = false;
			v[mal[i][0]][mal[i][1]] = false;
			mal[i][0] = tx;
			mal[i][1] = ty;
		}
	}

	private static boolean isMove(int idx, int go) {
		int x = mal[idx][0];
		int y = mal[idx][1];
		ret = 0;
		v[0][0] = false;
		if (x == 0 && y == 0) {
			x++;
			while (go-- > 0)
				if (map2[++x][y] == 0)
					go++;
		} else if (x == 1) {
			if (y == N - 1) {
				boolean f = false;
				while (go-- > 0) {
					if (map2[x][y] == 25 || f) {
						x--;
						y--;
						f = true;
					} else {
						x++;
						y--;
					}
					if (map2[x][y] == 0)
						go++;
				}
			} else {
				while (go-- > 0) {
					y--;
					if (y < 0) {
						end2[idx] = true;
						fff = true;
						mal[idx][0] = 0;
						mal[idx][1] = 0;
						return true;
					}
					if (map2[x][y] == 0)
						go++;
				}
			}
		} else if (x == N) {
			if (y == 0) {
				while (go-- > 0) {
					boolean f = false;
					if (map2[x][y] == 25 || f) {
						x--;
						y--;
						f = true;
					} else {
						x--;
						y++;
					}
					if (map2[x][y] == 0)
						go++;
				}
			} else if (y == N - 1) {
				while (go-- > 0) {
					x--;
					y--;
					if (map2[x][y] == 0)
						go++;
				}
			} else {
				while (go-- > 0) {
					if (y == N - 1)
						x--;
					else
						y++;
					if (map2[x][y] == 0)
						go++;
				}
			}
		} else if (y == 0) {
			while (go-- > 0) {
				if (x == N)
					y++;
				else
					x++;
				if (map2[x][y] == 0)
					go++;
			}
		} else if (y == N - 1) {
			while (go-- > 0) {
				if (x == 1)
					y--;
				else
					x--;
				if (map2[x][y] == 0)
					go++;
			}
		} else {
			boolean f = false;
			if (map2[x][y] < 20) {
				while (go-- > 0) {
					if (map2[x][y] == 25 || f) {
						x--;
						y--;
						if (y < 0) {
							end2[idx] = true;
							fff = true;
							mal[idx][0] = 0;
							mal[idx][1] = 0;
							return true;
						}
						f = true;
					} else {
						x--;
						y++;
					}
					if (map2[x][y] == 0)
						go++;
				}
			} else if (map2[x][y] < 30 && map2[x][y] > 25) {
				while (go-- > 0) {
					if (map2[x][y] == 25 || f) {
						x--;
						y--;
						if (y < 0) {
							end2[idx] = true;
							fff = true;
							mal[idx][0] = 0;
							mal[idx][1] = 0;
							return true;
						}
						f = true;
					} else {
						x++;
						y--;
					}
					if (map2[x][y] == 0)
						go++;
				}
			} else {
				while (go-- > 0) {
					x--;
					y--;
					if (y < 0) {
						end2[idx] = true;
						fff = true;
						mal[idx][0] = 0;
						mal[idx][1] = 0;
						return true;
					}
					if (map2[x][y] == 0)
						go++;
				}
			}
		}
		if (v[x][y])
			return false;
		else {
			v[x][y] = true;
			mal[idx][0] = x;
			mal[idx][1] = y;
			ret = map2[x][y];
			return true;
		}
	}

	static int[] same = { 25, 30, 35, 40 }; // 겹치는 부분

	private static void P(int idx, int sum) {
		if(idx == 10) {
			// 점수 계산하기
			if(sum > result) {
				System.out.print(Arrays.toString(turn));
				System.out.println(sum);
				result = sum;
			}
			
			return;
		}
		
		boolean dul = false;
		for(int i=1; i<=4; i++) {
			if(finish[i]) continue;
			int dist = list[i].dist + arr[idx];
			int dir = list[i].dir;
			Horse save = new Horse(list[i].dist, list[i].dir);
			turn[idx] = i;
			dul = false;
			int add = 0;
			// 방향 전환
			if(dir==4 && dist < end[4]) {
				if(map[4][dist] == 10) {
					dir = 1;
					dist = change[1];
				}else if(map[4][dist] == 20) {
					dir = 2;
					dist = change[2];
				}else if(map[4][dist] == 29) {
					add++;
					dir = 3;
					dist = change[3];
				}
			}
			// 도착
			if(dist >= end[dir]) {
				finish[i] = true;
				list[i].dir = dir;
				list[i].dist = end[dir];
				P(idx+1, sum);
				finish[i] = false;
			}else {
				// 겹치는지 확인
				outer:
				for(int j=1; j<=4; j++) {
					if(i==j || finish[j]) continue;
					for(int k=0; k<same.length;k++) {
						if(map[list[j].dir][list[j].dist] == same[k] && map[dir][dist] == same[k]) {
							dul = true; break outer;
						}
					}
					if(list[j].dir == dir && list[j].dist == dist) {
						dul = true; break;
					}
					
				}
				if(!dul) {
					list[i].dir = dir;
					list[i].dist = dist;
					P(idx+1, sum + map[dir][dist]+add);
				}
			}
			// 원래 값으로 돌려놓기
			list[i].dir = save.dir;
			list[i].dist = save.dist;
		}
	}
}

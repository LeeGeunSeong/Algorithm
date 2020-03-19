import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이_이근성2 {
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int N,ret,ans;
	static int[] arr,print;
	static int[][] mal;
	static boolean fff;
	static boolean[] end;
	static boolean[][] v;
	static int[][] map = {{0},
						  {40,38,0,36,0,34,0,32,30},
						  {2,0,0,0,0,0,0,28,28},
						  {0,0,35,0,0,0,27,0,0},
						  {4,0,0,30,0,26,0,0,26},
						  {0,0,0,0,25,0,0,0,0},
						  {6,0,0,19,0,24,0,0,24},
						  {0,0,16,0,0,0,22,0,0},
						  {8,13,0,0,0,0,0,0,22},
						  {10,12,0,14,0,16,0,18,20}}; // 9 by 9
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = 9;
		arr = new int[10];
		print = new int[10];
		v = new boolean[N+1][N];
		end = new boolean[4];
		mal = new int[4][2];
			
		ans = 0;
		for (int i = 0; i < 10; i++) arr[i] = Integer.parseInt(st.nextToken()); 
			
		dfs(0,0);
		System.out.println(ans);
	}
	private static void dfs(int cnt,int sum) {
		if(cnt == 10) {
			if(sum > ans) {
				System.out.print(Arrays.toString(print));
				System.out.println(sum);
				ans = sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(end[i]) continue;
			int tx = mal[i][0];	int ty = mal[i][1];
			fff = false;
			if(!isMove(i,arr[cnt])) continue; 
			print[cnt] = i+1;
			boolean f = fff;
			v[tx][ty] = false;
			dfs(cnt+1,sum+ret);
			v[tx][ty] = true;
			if(f) end[i] = false;
			v[mal[i][0]][mal[i][1]] = false;
			mal[i][0] = tx; mal[i][1] = ty;
		}
	}
	private static boolean isMove(int idx, int go) {
		int x = mal[idx][0]; int y = mal[idx][1];
		ret = 0;
		v[0][0] = false;
		if(x==0  && y==0) {
			x++;
			while(go-- > 0) if(map[++x][y] == 0) go++;
		}else if(x==1) {
			if(y==N-1) {
				boolean f = false;
				while(go-- >0) {
					if(map[x][y] == 25 || f) {
						x--;y--;
						f = true;
					}else {
						x++; y--;
					}
					if(map[x][y] == 0) go++;
				}
			}else {
				while(go-- >0) {
					y--;
					if(y < 0) {
						end[idx] = true; fff = true;
						mal[idx][0]= 0; mal[idx][1]= 0; 
						return true;
					}
					if(map[x][y] == 0) go++;
				}
			}
		}else if(x==N) {
			if(y==0) {
				while(go-- >0) {
					boolean f = false;
					if(map[x][y] == 25 || f) {
						x--;y--;
						f = true;
					}else {
						x--; y++;
					}
					if(map[x][y] == 0) go++;
				}
			}else if(y==N-1) {
				while(go-- >0) {
					x--; y--;
					if(map[x][y] == 0) go++;
				}
			}else {
				while(go-- >0) {
					if(y == N-1) x--;
					else y++;
					if(map[x][y] == 0) go++;
				}
			}
		}else if(y==0) {
			while(go-- >0) {
				if(x == N) y++;
				else x++;
				if(map[x][y] == 0) go++;
			}
		}else if(y==N-1) {
			while(go-- >0) {
				if(x == 1) y--;
				else x--;
				if(map[x][y] == 0) go++;
			}
		}else {
			boolean f = false;
			if(map[x][y] < 20) {
				while(go-- >0) {
					if(map[x][y] == 25 || f) {
						x--; y--;
						if(y < 0) {
							end[idx] = true; fff = true;
							mal[idx][0]= 0; mal[idx][1]= 0;
							return true;
						}
						f = true;
					}else {
						x--; y++;
					}
					if(map[x][y] == 0) go++;
				}
			}else if(map[x][y] < 30 && map[x][y] > 25) {
				while(go-- >0) {
					if(map[x][y] == 25 || f) {
						x--; y--;
						if(y < 0) {
							end[idx] = true; fff = true;
							mal[idx][0]= 0; mal[idx][1]= 0;
							return true;
						}
						f = true;
					}else {
						x++; y--;
					}
					if(map[x][y] == 0) go++;
				}
			}else {
				while(go-- >0) {
					x--; y--;
					if(y < 0) {
						end[idx] = true; fff = true;
						mal[idx][0]= 0; mal[idx][1]= 0;
						return true;
					}
					if(map[x][y] == 0) go++;
				}
			}
		}
		if(v[x][y]) return false;
		else { 
			v[x][y] = true;
			mal[idx][0] = x; mal[idx][1] = y;
			ret = map[x][y];
			return true;
		}
	}
}
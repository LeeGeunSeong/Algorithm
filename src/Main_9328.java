import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class SG{
		int x,y,val;
		public SG(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[h+2][w+2];
			for (int i = 0; i < w; i++) {
				map[0][i] = '.';
				map[h+1][i] = '.';
			}
			for (int i = 1; i < h+1; i++) {
				map[i][0] = '.';
				map[i][w+1] = '.';
				String str = br.readLine();
				for (int j = 1; j < w+1; j++) {
					map[i][j] = str.charAt(j-1);
				}
			}
			String tmp = br.readLine();
			List<Character> key = new ArrayList<>();
			List<Character> door = new ArrayList<>();
			List<Character> openDoor = new ArrayList<>();
			for (int i = 0; i < tmp.length(); i++) {
				key.add(tmp.charAt(i));
			}
			Queue<Point> q = new LinkedList<>();
			boolean[][] v = new boolean[h+2][w+2]; 
			q.add(new Point(0,0));
			v[0][0] = true;
			int ans = 0;
			outer:
			while(!q.isEmpty()) {
				Point cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				if(map[x][y] >= 'A' && map[x][y] <= 'Z') {
					if(!check(key,map[x][y])) {
						q.add(new Point(x,y));
						if(q.size() == door.size() - openDoor.size()) {
							boolean flag = true;
							for (int i = 0; i < q.size(); i++) {
								Point p = q.poll();
								for (int j = 0; j < key.size(); j++) {
									if(key.get(j) == Character.toLowerCase(map[p.x][p.y]))
										flag = false;
								}
								q.add(p);
							}
							if(flag) break outer;
						}
						continue;
					}else openDoor.add(map[x][y]);
				}
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx > h+1 || ny < 0 || ny > w+1
							||v[nx][ny] || map[nx][ny] == '*') continue;
					if(map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') door.add(map[nx][ny]);
					if(map[nx][ny] >= 'a' && map[nx][ny] <= 'z') key.add(map[nx][ny]);
					if(map[nx][ny] == '$') ans++;
					q.add(new Point(nx, ny));
					v[nx][ny] = true;
				}
			}
			System.out.println(ans);
		}
	}
	private static boolean check(List<Character> key, char c) {
		for (int i = 0; i < key.size(); i++) {
			if(key.get(i) == Character.toLowerCase(c)) return true;
		}
		return false;
	}
}

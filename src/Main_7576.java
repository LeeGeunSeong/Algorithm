import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
class map{
	int x,y,day;
	public map(int x, int y, int day) {
		super();
		this.x = x;
		this.y = y;
		this.day = day;
	}
}
public class Main_7576 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 가로
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		List<map> mList = new LinkedList<map>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					mList.add(new map(i,j,0));
				}
			}
		}
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int cnt = 0;
		int ans = 0;
		while(!mList.isEmpty()) {
			int nx = mList.get(cnt).x;
			int ny = mList.get(cnt).y;
			int day =0;
			for (int j = 0; j < dy.length; j++) {
				day = mList.get(cnt).day;
				nx = mList.get(cnt).x + dx[j];
				ny = mList.get(cnt).y + dy[j];
				if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1) continue;
				if(map[nx][ny] == -1) continue;
				if(map[nx][ny] == 0) {
					map[nx][ny] = 1;
					mList.add(new map(nx,ny,++day));
					ans = Math.max(day, ans);
				}
			}
			mList.remove(cnt);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) ans = -1;
			}
		}
		System.out.println(ans);
	}
}

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18809 {
	static int N,M,G,R,ans;
	static int[] arrR,arrG;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static List<Point> point;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arrR = new int[R];
		arrG = new int[G];
		map = new int[N][M];
		point = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) point.add(new Point(i,j));
			}
		}
		dfs(0,0,0);
	}

	private static void dfs(int cnt, int idxR, int idxG) {
		if(idxR==R && idxG==G) {
			ans = Math.max(ans, bfs());
		}else if(idxR==R) {
			arrG[idxG] = cnt;
			dfs(cnt+1,idxR,idxG+1);
			arrG[idxG] = 0;
		}else if(idxG==G) {
			arrR[idxR] = cnt;
			dfs(cnt+1,idxR+1,idxG);
			arrR[idxR] = 0;
		}else {
			if(cnt>G+R) return;
			arrG[idxG] = cnt;
			dfs(cnt+1,idxR,idxG+1);
			arrG[idxG] = 0;
			arrR[idxR] = cnt;
			dfs(cnt+1,idxR+1,idxG);
			arrR[idxR] = 0;
			dfs(cnt+1,idxR,idxG);
		}
	}

	private static int bfs() {
		Queue<Point> r = new LinkedList<>();
		Queue<Point> g = new LinkedList<>();
		for (int i = 0; i < R; i++) 
			r.offer(point.get(arrR[i]));
		for (int i = 0; i < G; i++) 
			g.offer(point.get(arrG[i]));
		
		return 0;
	}
}

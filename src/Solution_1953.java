import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {

	// 지하 터널 지도의 세로 크기 N, 가로 크기 M, 
	// 맨홀 뚜껑이 위치한장소의 세로 위치 R, 가로 위치 C, 그리고 탈출 후 소요된 시간 L 
	static int N,M,R,C,L,result;
	static int[][] map;
	static int[] dx = {0,0,1,-1};  
	static int[] dy = {1,-1,0,0};
	static int[][] possilbe = {{1,3,6,7},{1,3,4,5},{1,2,4,7},{1,2,5,6}};
	// 우 좌 하 상
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			BFS(R,C);
			
			System.out.println("#" + t + " " + result);
		}
	}
	private static void BFS(int x, int y) {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x,y));
		visited[x][y] = true;
		
		int cx,cy,nx,ny, size;
		int time = 1;
		while(!q.isEmpty()) {
			size = q.size();
			result += size;
			if(time==L) break;
			for(int i=0; i<size; i++) {
				Point tmp = q.poll();
				cx = tmp.x; cy = tmp.y;
				switch (map[cx][cy]) {
				// 상하좌우
				case 1:
					for(int d=0; d<4; d++) {
						nx = cx+dx[d]; ny = cy+dy[d];
						
						if(nx <0 || ny <0 || nx>=N || ny>=M) continue;
						if(map[nx][ny]!=0 && check(d, nx,ny) && !visited[nx][ny]) {
							visited[nx][ny] = true;
							q.offer(new Point(nx,ny));
						}
					}
					break;
					// 우 좌 하 상
				// 상하
				case 2:
					nx = cx+dx[3]; ny = cy+dy[3];
					if(nx>=0 && check(3, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}

					nx = cx+dx[2]; ny = cy+dy[2];
					if(nx<N && check(2, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}

					break;
				// 좌우
				case 3:
					nx = cx+dx[1]; ny = cy+dy[1];
					if(ny>=0 && check(1, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					
					nx = cx+dx[0]; ny = cy+dy[0];
					if(ny<M && check(0, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					break;
				// 상우
				case 4:
					nx = cx+dx[3]; ny = cy+dy[3];
					if(nx>=0 && check(3, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					
					nx = cx+dx[0]; ny = cy+dy[0];
					if(ny<M && check(0, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					
					break;
				// 하우
				case 5:
					nx = cx+dx[2]; ny = cy+dy[2];
					if(nx<N && check(2, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					
					nx = cx+dx[0]; ny = cy+dy[0];
					if(ny<M && check(0, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					
					break;
				// 하좌
				case 6:
					nx = cx+dx[2]; ny = cy+dy[2];
					if(nx<N && check(2, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					
					nx = cx+dx[1]; ny = cy+dy[1];
					if(ny>=0 && check(1, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					break;
					
				// 상좌
				case 7:
					nx = cx+dx[3]; ny = cy+dy[3];
					if(nx>=0 && check(3, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					
					nx = cx+dx[1]; ny = cy+dy[1];
					if(ny>=0  && check(1, nx,ny) &&!visited[nx][ny]) {
						visited[nx][ny] = true; q.offer(new Point(nx,ny));
					}
					break;
				}
			} /// for문 끝
			time++;
		}
	}
	private static boolean check(int i, int nx, int ny) {
		for(int j=0; j<4; j++) 
			if(map[nx][ny]==possilbe[i][j]) return true;
		return false;
	}
}
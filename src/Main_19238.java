import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19238 {
	static class Person{
		Point s,e;

		public Person(Point s, Point e) {
			super();
			this.s = s;
			this.e = e;
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 맵 크기
		int M = Integer.parseInt(st.nextToken()); // 승객 수
		int fuel = Integer.parseInt(st.nextToken()); // 연료
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		Point s = new Point();
		st = new StringTokenizer(br.readLine());
		s.x = Integer.parseInt(st.nextToken());
		s.y = Integer.parseInt(st.nextToken());
		List<Person> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			Point end = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			list.add(new Person(start, end));
		}
		while(fuel > 0) {
			// 가장 가까운 승객 찾기
			
			// 이동
			
			// 연료 충전
		}
	}
}


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이_이근성4 {

	static int[][] map = {
			{},
			{0 ,2 ,4 ,6 ,8 ,10, 13, 16, 19, 25, 30, 35, 40, -1},
			{0 ,2 ,4 ,6 ,8 ,10 ,12 ,14 ,16 ,18 ,20 ,22 ,24 ,25 ,30 ,35 ,40, -1},
			{0 ,2 ,4 ,6 ,8 ,10 ,12 ,14 ,16 ,18 ,20 ,22 ,24 ,26 ,28 ,30, 28, 27, 26, 25, 30, 35, 40, -1},
			{0 ,2 ,4 ,6 ,8 ,10 ,12, 14 ,16 ,18 ,20 ,22 ,24 ,26 ,28 ,30, 32, 34, 36, 38, 40, -1}
			};
	static int[] change = {0,5, 10, 15};
	static int[] end = {0, 13, 17, 23, 21}; // 끝 index
	static boolean[] finish;
	static int[] turn, dice;
	static Horse[] list;
	static int result;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		turn = new int[10]; // 말 -4개
		dice = new int[10]; // 주사위 - 1~5
		
		for(int i=0; i<10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		finish = new boolean[5];
		
		list = new Horse[5];
		for(int i=1; i<=4; i++) {
			list[i] = new Horse(0, 4);
		}
		
//		for(int i=1; i<=4; i++) {
//			System.out.println(map[i].length);
//		}
		
		
		result = -1;
		
		// 말의 순서정하기
		P(0,0);
		
		System.out.println(result);
	}
	private static void P(int idx, int sum) {
		if(idx == 10) {
			// 점수 계산하기
			if(sum > result) {
//				System.out.println(Arrays.toString(turn)+" " + sum);
				result = sum;
			}
			
			return;
		}
		
		Horse tmp = new Horse(0, 0);
		boolean dul = false;
		for(int i=1; i<=4; i++) {
			if(finish[i]) continue;
			
			int dist = list[i].dist;
			int dir = list[i].dir;
			
			turn[idx] = i;
			dul = false;

			tmp.dir = list[i].dir;
			tmp.dist = list[i].dist + dice[idx];
			
			// 방향 전환
			if(list[i].dir==4 && tmp.dist < end[4]) {
				if(map[4][tmp.dist] == 10) {
					tmp.dir = 1;
					tmp.dist = change[1];
				}else if(map[4][tmp.dist] == 20) {
					tmp.dir = 2;
					tmp.dist = change[2];
				}else if(map[4][tmp.dist] == 30) {
					tmp.dir = 3;
					tmp.dist = change[3];
				}
			}
			// 도착
			if(tmp.dist >= end[tmp.dir]) {
				finish[i] = true;
				P(idx+1, sum);
				finish[i] = false;
			}else {
				// 겹치는지 확인
				for(int j=1; j<=4; j++) {
					if(i==j || finish[j]) continue;
					
					// 겹쳐서 이동할 수 없음 -- 다시 원래대로
					if(list[j].dir == tmp.dir && list[j].dist == tmp.dist
							|| (map[list[j].dir][list[j].dist] == 25 && map[tmp.dir][tmp.dist] == 25)
							|| (map[list[j].dir][list[j].dist] == 40 && map[tmp.dir][tmp.dist] == 40)){
						dul = true; break;
					}
				}
				if(!dul) {
					list[i].dir = tmp.dir;
					list[i].dist = tmp.dist;
					
					P(idx+1, sum + map[list[i].dir][list[i].dist]);
					
				}
				
			}
			// 원래 값으로 돌려놓기
			list[i].dir = dir;
			list[i].dist = dist;
			turn[idx] = 0;
			
			
			
		}
		
	}
	
	
	static class Horse{
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

}
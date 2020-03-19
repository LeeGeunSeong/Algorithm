
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이_이근성3 {

	static int[][] map = {
			{},
			{0 ,2 ,4 ,6 ,8 ,10, 13, 16, 19, 25, 30, 35, 40, -1},
			{0 ,2 ,4 ,6 ,8 ,10 ,12 ,14 ,16 ,18 ,20 ,22 ,24 ,25 ,30 ,35 ,40, -1},
			{0 ,2 ,4 ,6 ,8 ,10 ,12 ,14 ,16 ,18 ,20 ,22 ,24 ,26 ,28 ,29, 28, 27, 26, 25, 30, 35, 40, -1},
			{0 ,2 ,4 ,6 ,8 ,10 ,12, 14 ,16 ,18 ,20 ,22 ,24 ,26 ,28 ,29, 32, 34, 36, 38, 40, -1}
			};
	static int[] change = {0,5, 10, 15};
	static int[] end = {0, 13, 17, 23, 21}; // 끝 index
	static int[] same = {25,30,35,40}; // 겹치는 부분
	static boolean[] finish;
	static int[] turn, dice;
	static Horse[] list;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		turn = new int[10]; // 말 -4개
		dice = new int[10]; // 주사위 - 1~5
		
		for(int i=0; i<10; i++) dice[i] = Integer.parseInt(st.nextToken());
		

		finish = new boolean[5];
		
		list = new Horse[5];
		for(int i=1; i<=4; i++) list[i] = new Horse(0, 4);
		
		result = -1;
		
		// 말의 순서정하기
		P(0,0);
		
		System.out.println(result);
	}
	private static void P(int idx, int sum) {
		if(idx == 10) {
			// 점수 계산하기
			if(sum > result) {
				result = sum;
			}
			
			return;
		}
		
		boolean dul = false;
		for(int i=1; i<=4; i++) {
			if(finish[i]) continue;
			int dist = list[i].dist + dice[idx];
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
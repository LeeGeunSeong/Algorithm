import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4_이근성 {
	static int N,M,K; // N : 열  M : 행  K : 회전 횟수
	static int[] r,c,s;
	static int[][] A, newArr;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) 
				A[i][j] = Integer.parseInt(st.nextToken());  
		}
		r = new int[K];
		c = new int[K];
		s = new int[K];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		} // end input
		newArr = new int[N][M];
		for (int i = 0; i < K; i++) {
			dfs(rotateArr(A,i),1,i, 1 << i);
			initArr(A, newArr);
		}
		
		System.out.println(min);
	}
	private static void dfs(int[][] arr, int cnt, int idx, int visited) {
		if(cnt == K) {
			min = Math.min(min, calc(arr));
			return;
		}
		for (int i = 0; i < K; i++) {
			if((visited & (1<<i)) == 0) { 
				newArr = rotateArr(arr, i);
				dfs(newArr,cnt+1,i, visited | (1<<i));
				initArr(arr,newArr);
			}
		}
	}
	
	private static void initArr(int[][] arr, int[][] newArr2) {
		for (int i = 0; i < N; i++) {
			newArr2[i] = Arrays.copyOf(arr[i], M);
		}
		
	}

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	private static int[][] rotateArr(int[][] arr, int idx){
		int[][] tmp = new int[N][M];
		initArr(arr,tmp);
		int cnt = 1;
		while(cnt <= s[idx]) {
			int x1 = r[idx] - cnt-1;
			int x2 = r[idx] + cnt-1;
			int y1 = c[idx] - cnt-1;
			int y2 = c[idx] + cnt-1;
			int dir = -1;
			int i = x1;
			int j = y1;
			int temp = tmp[x1][y1];
			int temp2 = 0;
			int count = 0;
			while(true) {
				if(count != 0 && i == x1 && j == y1) {
					cnt++;
					break;
				}
				if( (i == x1 && j == y1) || (i == x2 && j == y1) 
						||(i == x1 && j == y2) || (i == x2 && j == y2)) dir = (++dir)%4;
				i += dx[dir];
				j += dy[dir];
				temp2 = tmp[i][j];
				tmp[i][j] = temp;
				temp = temp2;
				count++;
			}
				
			}
		return tmp;
		
	}
	private static int calc(int[][] arr) {
		int minLine = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) 
				sum += arr[i][j]; 
			minLine = Math.min(sum, minLine);
		}
		return minLine;
	}
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2074_홀수마방진_이근성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int x = 0;
		int y = N/2;
		
		for (int i = 1; i <= N*N; i++) {
			map[x][y] = i;
			if(i%N == 0) {
				x++;
				continue;
			}
			x--; y--;
			if(x < 0) x = N-1;
			if(y < 0) y = N-1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
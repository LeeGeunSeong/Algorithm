import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17140 {
	static int r,c,k;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		map = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int sec = 0;
		int row = 3, col = 3;
		while(map[r][c] != k && sec++ <= 100) {
			int maxlen = 0, max = 0;
			if(row >= col) {
				for (int i = 0; i < row; i++) {
					int[] count = new int[101];
					int[][] arr = new int[50][2];
					for (int j = 0; j < col; j++) {
						count[map[i][j]]++;
						max = Math.max(max, map[i][j]);
						map[i][j] = 0;
					}
					int idx = 0;
					for (int j = 1; j <= max; j++) {
						if(count[j] == 0) continue;
						arr[idx][0] = j;
						arr[idx++][1] = count[j];
					}
					Arrays.sort(arr, new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							return o1[1]-o2[1]==0?o1[0]-o2[0]:o1[1]-o2[1];
						}
					});
					int arridx = idx;
					idx = 0;
					for (int j = 50 - arridx; j < 50; j++) {
						if(idx > 100) break;
						map[i][idx++] = arr[j][0]; 
						map[i][idx++] = arr[j][1];
					}
					maxlen = Math.max(maxlen, idx);
				}
				col = maxlen;
			}else {
				for (int i = 0; i < col; i++) {
					int[] count = new int[101];
					int[][] arr = new int[50][2];
					for (int j = 0; j < row; j++) {
						count[map[j][i]]++;
						max = Math.max(max, map[j][i]);
						map[j][i] = 0;
					}
					int idx = 0;
					for (int j = 1; j <= max; j++) {
						if(count[j] == 0) continue;
						arr[idx][0] = j;
						arr[idx++][1] = count[j];
					}
					Arrays.sort(arr, new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							return o1[1]-o2[1]==0?o1[0]-o2[0]:o1[1]-o2[1];
						}
					});
					int arridx = idx;
					idx = 0;
					for (int j = 50 - arridx; j < 50; j++) {
						if(idx > 100) break;
						map[idx++][i] = arr[j][0]; 
						map[idx++][i] = arr[j][1];
					}
					maxlen = Math.max(maxlen, idx);
				}
				row = maxlen;
			}
		}
		
		System.out.println(sec>100?-1:sec);
	}
}

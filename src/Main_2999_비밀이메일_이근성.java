import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2999_비밀이메일_이근성 {
	static int N,R,C,ans;
	static int[][] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		N = ch.length;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if(i*j == N) {
					R = i;
					C = j;
				}
			}
		}
		char[][] map = new char[R][C];
		int tmp = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				map[j][i] = ch[tmp++];
			}
		}
		String ans = "";
		for (int i = 0; i < R; i++) 
			for (int j = 0; j < C; j++) 
				ans += map[i][j]; 
		System.out.println(ans);
	}//end main
}
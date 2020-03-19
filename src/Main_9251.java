import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_9251 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		int N = A.length();
		int M = B.length();
		int[][] lcs = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(B.charAt(j-1) == A.charAt(i-1)) 
					lcs[i][j] = lcs[i-1][j-1] + 1;
				else 
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}			
		}
		System.out.println(lcs[N][M]);
	}
}

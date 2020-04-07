import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2775_부녀회장이될테야_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[15][15];
		for (int i = 1; i < 15; i++) dp[0][i] = i;
		for (int i = 1; i < 15; i++) 
			for (int j = 1; j < 15; j++) 
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
		for (int tc = 0; tc < t; tc++) System.out.println(dp[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())]);
		
	}
}

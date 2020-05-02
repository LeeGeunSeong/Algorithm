import java.util.Arrays;
import java.util.Scanner;

public class Main_10809_알파벳찾기_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] alpha = new int[26];
		Arrays.fill(alpha, -1);
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if(alpha[tmp-'a'] > -1) continue;
			alpha[tmp-'a'] = i;
		}
		for (int i = 0; i < alpha.length; i++) {
			System.out.print(alpha[i] + " ");
		}
	}
	
}

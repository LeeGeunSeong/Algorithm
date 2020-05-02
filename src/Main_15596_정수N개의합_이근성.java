import java.util.Scanner;

public class Main_15596_정수N개의합_이근성 {
	public static void main(String[] args) {
	}
	long sum(int[] a) {
        long ans = 0;
        for (int i = 0; i < a.length; i++) {
			ans += a[i];
		}
        return ans;
    }
	
}

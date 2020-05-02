import java.util.Scanner;

public class Main_10818_최소최대_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int max = -10000000, min = 10000000;
		for (int i = 0; i < a; i++) {
			int n = sc.nextInt();
			max = Math.max(max, n);
			min = Math.min(min, n);
		}
		System.out.println(min + " " + max);
	}
}

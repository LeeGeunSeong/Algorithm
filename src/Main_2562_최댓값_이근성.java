import java.util.Scanner;

public class Main_2562_최댓값_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0,maxidx = 0;
		for (int i = 0; i < 9; i++) {
			int a = sc.nextInt();
			if(a > max) {
				max = a;
				maxidx = i+1;
			}
		}
		System.out.println(max);
		System.out.println(maxidx);
	}
}

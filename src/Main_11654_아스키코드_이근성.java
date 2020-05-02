import java.util.Scanner;

public class Main_11654_아스키코드_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			char tmp = str.charAt(i);
			sum += tmp - '0';
		}
		System.out.println(sum);
	}
	
}

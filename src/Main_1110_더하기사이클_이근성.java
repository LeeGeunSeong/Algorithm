import java.util.Scanner;

public class Main_1110_더하기사이클_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int tmp = n;
		while(true) {
			cnt++;
			int a = tmp / 10;
			int b = tmp % 10;
			tmp = (b*10)+(a+b)%10;
			if(tmp == n) break;
		}
		System.out.println(cnt);
	}
}

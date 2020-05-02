import java.util.Scanner;

public class Main_1065_한수_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		if(N < 100) ans = N;
		else {
			ans = N==1000?98:99;
			for (int i = 100; i <= N; i++) {
				int tmp = i;
				int x = tmp % 10;
				tmp /= 10;
				int y = tmp % 10;
				tmp /= 10;
				int z = tmp % 10;
				if(x-y == y-z) ans++;
			}
		}
		
		System.out.println(ans);
	}
	
}

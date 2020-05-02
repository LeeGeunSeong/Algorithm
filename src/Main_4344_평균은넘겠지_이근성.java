import java.util.Scanner;

public class Main_4344_평균은넘겠지_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			double aver = 0.0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				aver += arr[i];
			}
			aver /= N;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if(arr[i] > aver) cnt++;
			}
			System.out.printf("%.3f%% \n",(cnt/(double)N)*100);
		}
	}
}

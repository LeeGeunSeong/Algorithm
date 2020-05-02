import java.util.Scanner;

public class Main_1546_평균_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int M = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			M = Math.max(M, arr[i]);
		}
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (arr[i]/(double)M)*100;
		}
		System.out.println(sum/N);
	}
}

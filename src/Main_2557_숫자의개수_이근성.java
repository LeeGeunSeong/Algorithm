import java.util.Scanner;

public class Main_2557_숫자의개수_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[10];
		
		int mul = a * b * c;
		
		while(mul > 0) {
			int x = mul % 10;
			arr[x]++;
			mul /= 10;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}

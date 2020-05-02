import java.util.Scanner;

public class Main_10871_X보다작은수_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
				
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			if(x > t) System.out.print(t+" ");
		}
	}
}

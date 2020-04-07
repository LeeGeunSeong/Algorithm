import java.util.Scanner;

public class Main_2920_음계_이근성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		boolean f1 = true,f2 = true;
		for (int i = 1; i < 8; i++) {
			int b = sc.nextInt();
			if(b - a == 1 && f1) {
				f2 = false;
			}else if(a - b == 1 && f2) {
				f1 = false;
			}else {
				f1 = false; f2 = false;
				System.out.println("mixed");
				break;
			}
			a = b;
		}
		if(f1) System.out.println("ascending");
		else if(f2) System.out.println("descending");
	}
}

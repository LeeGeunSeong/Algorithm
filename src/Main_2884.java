import java.util.Scanner;

public class Main_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(b<45?a>=1?a-1+" "+(b+15):a+23+" "+(b+15):a + " " + (b-45));
	}
}
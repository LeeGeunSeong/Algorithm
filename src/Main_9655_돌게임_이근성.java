import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9655_돌게임_이근성 {
	static int N;
	static boolean skWin;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		skWin = false;
		
		if(N%2 == 1) skWin = true;
		else skWin = false;
		
		if(skWin) System.out.println("SK");
		else System.out.println("CY");
	}
}

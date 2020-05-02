import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3052_나머지_이근성 {
	static int N;
	static boolean skWin;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		int[] div = new int[42];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arr[i] = arr[i] % 42;
			div[arr[i]]++;
		}
		int ans = 0;
		for (int i = 0; i < div.length; i++) {
			if(div[i] != 0) ans++;
		}
		System.out.println(ans);
	}
}

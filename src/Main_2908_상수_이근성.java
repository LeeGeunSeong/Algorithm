import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908_상수_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[2];
		for (int i = 0; i < 2; i++) {
			char[] tmp = st.nextToken().toCharArray();
			for (int j = 0; j < tmp.length; j++) {
				tmp[j] -= '0';
			}
			arr[i] = tmp[2] * 100 + tmp[1] * 10 + tmp[0];
		}
		System.out.println(Math.max(arr[0], arr[1]));
	}
}

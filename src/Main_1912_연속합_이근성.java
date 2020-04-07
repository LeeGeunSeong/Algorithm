import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		int max = arr[0];
		
		for (int i = 1; i < N; i++) {
			if(arr[i] < arr[i-1] + arr[i]) 
				arr[i] = arr[i-1] + arr[i];
			max = Math.max(max, arr[i]);
		}
		System.out.println(max);
	}
}

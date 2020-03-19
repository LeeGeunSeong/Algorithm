import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		int idx = 0;
		for (int i = 0; i < K; i++) {
			if(arr[i] == 0) {
				ans -= arr[idx];
				arr[idx] = 0;
				for (int j = idx-1; j >= 0; j--) {
					if(arr[j] > 0) {
						idx = j;
						break;
					}
				}
			}else {
				ans += arr[i];
				idx = i;
			}
		}
		System.out.println(ans);
	}
}

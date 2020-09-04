import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10162 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[3];
		int[] sec = {300,60,10};
		int idx = 0;
		while(T > 0) {
			while(idx < 3 && sec[idx] > T) idx++;
			if(idx > 2) {
				System.out.println(-1);
				return;
			}
			T -= sec[idx];
			arr[idx]++;
		}
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i]+ " ");
	}
}

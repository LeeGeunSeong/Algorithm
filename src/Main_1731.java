import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1731 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		int x = 0;
		
		if(arr[2]-arr[1] == arr[1]-arr[0]) {
			x = arr[2]-arr[1];
			System.out.println(arr[N-1]+x);
		}
		else {
			x = arr[2]/arr[1];
			System.out.println(arr[N-1]*x);
		}
			
	}
}

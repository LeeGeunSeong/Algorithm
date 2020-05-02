import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11399_ATM_이근성 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());;
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		int sum = 0;
		for (int i = 0; i < N; i++) 
			for (int j = 0; j <= i; j++) 
				sum += arr[j];
		System.out.println(sum);
	}//end main
}
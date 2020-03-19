import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] num = br.readLine().toCharArray();
		
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		
		for (int i = num.length-1; i >= 0; i--) 
			sb.append(num[i]);
		System.out.println(sb.toString());
	}
}

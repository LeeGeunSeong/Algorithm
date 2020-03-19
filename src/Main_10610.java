import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] num = br.readLine().toCharArray();
		boolean flag = false;
		StringBuilder ans = new StringBuilder();
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			int x = num[i] - '0';
		 	if(x==0) flag = true;
		 	sum += x;
		}
		if(sum%3 != 0) flag = false;
		
		if(!flag) System.out.println(-1);
		else {
			Arrays.sort(num);
			for (int i = num.length-1; i >=0; i--) 
				ans.append(num[i]);
			System.out.println(ans.toString());
		}
		
	}
}

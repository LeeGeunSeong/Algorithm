import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] strA = str.split("-");
		int ans = 0;
		for (int i = 0; i < strA.length; i++) {
			String[] tmp = strA[i].split("\\+");
			
			int tmpSum = 0;
			for (int j = 0; j < tmp.length; j++) 
				tmpSum += Integer.parseInt(tmp[j]);
			
			if(i == 0) tmpSum *= -1;
			ans -= tmpSum;
		}
		System.out.println(ans);
	}
}

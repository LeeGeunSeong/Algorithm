import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] serial = new String[N];
		
		for (int i = 0; i < N; i++) 
			serial[i] = br.readLine();
		Arrays.sort(serial, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				int compSum = compareSum(o1, o2);
				return o1.length()-o2.length()==0?compSum==0?o1.compareTo(o2):compSum:o1.length()-o2.length();
			}

			private int compareSum(String o1, String o2) {
				String tmp1 = o1.replaceAll("[^0-9]", "");
				String tmp2 = o2.replaceAll("[^0-9]", "");
				int sum1=0,sum2=0;
				for (int i = 0; i < tmp1.length(); i++) 
					sum1 += tmp1.charAt(i)-'0';
				for (int i = 0; i < tmp2.length(); i++) 
					sum2 += tmp2.charAt(i)-'0';
				return sum1-sum2;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) 
			sb.append(serial[i]+"\n");
		System.out.println(sb.toString());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] strs = new String[N];
		
		for (int i = 0; i < N; i++) {
			strs[i] = br.readLine();
		}
		
		Arrays.sort(strs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length()==0?o1.compareTo(o2):o1.length()-o2.length();
			}
		});
		outer:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) 
				if(strs[i].equals(strs[j])) continue outer;
			System.out.println(strs[i]);
		}
	}
}

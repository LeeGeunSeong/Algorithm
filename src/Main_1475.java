import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int ans = 0;
		int pla = 0;
		int[] arr = new int[11];
		for (int i = 0; i < num.length(); i++) {
			
			int tmpNum = num.charAt(i)-'0';
			
			if(arr[tmpNum] > 0) arr[tmpNum]--;
			else {
				if(tmpNum==6 && arr[9] > 0) arr[9]--;
				else if(tmpNum==9 && arr[6] > 0) arr[6]--;
				else {
					for (int j = 0; j < 10; j++) arr[j]++;
					arr[tmpNum]--;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main_1157_단어공부_이근성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if(map.containsKey(ch)) 
				map.replace(ch, map.get(ch)+1);
			else
				map.put(ch, 1);
		}
		int max = 0;
		char ans = ' ';
		for (char ch : map.keySet()) {
			int tmp = map.get(ch);
			if(tmp > max) {
				max = tmp;
				ans = ch;
			}
		}
		for (char ch : map.keySet()) {
			int tmp = map.get(ch);
			if(tmp == max && ch != ans) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}

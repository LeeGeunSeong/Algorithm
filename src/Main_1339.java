import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main_1339 {
	static int ans, size;
	static boolean[] v;
	static String[] input;
	static char[] alphabet;
	static Map<Character, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new String[N];
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
			for (int j = 0; j < input[i].length(); j++) {
				set.add(input[i].charAt(j));
			}
		}
		size = set.size();
		alphabet = new char[size];
		v = new boolean[10];
		map = new HashMap<>();
		int idx = 0;
		for (Character ch : set) 
			alphabet[idx++] = ch;
		
		findNum(0);
		System.out.println(ans);
	}
	private static void findNum(int cnt) {
		if(cnt == size) {
			ans = Math.max(ans, sum());
			return;
		}
		for (int i = 0; i < 10; i++) {
			if(v[i]) continue;
			v[i] = true;
			map.put(alphabet[cnt], i);
			findNum(cnt+1);
			v[i] = false;
		}
	}
	private static int sum() {
		int ret = 0;
		for (int i = 0; i < input.length; i++) {
			int sum = 0;
				for (int j = 0; j < input[i].length(); j++) {
					sum *= 10;
					sum += map.get(input[i].charAt(j));
				}
			ret += sum;
		}
		return ret;
	}
	
}

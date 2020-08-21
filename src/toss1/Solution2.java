package toss1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		boolean answer = true;
		if(input.split(" ").length != 6) {
			answer = false;
		}else {
			StringTokenizer st = new StringTokenizer(input);
			int[] lotto = new int[6];
			for (int i = 0; i < 6; i++) {
				try {
					lotto[i] = Integer.parseInt(st.nextToken());
				}catch(NumberFormatException e) {
					answer = false;
				}
			}
			int bef = lotto[0];
			if(bef < 1 && bef > 45) {
				answer = false;
			}else {
				for (int i = 1; i < 6; i++) {
					int cur = lotto[i];
					if(cur < 1 && cur > 45) {
						answer = false;
						break;
					}
					if(cur <= bef) {
						answer = false;
						break;
					}
					bef = cur;
				}
			}
		}
		System.out.println(answer);
	}
}

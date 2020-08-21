package toss1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char bef = input.charAt(0);
		boolean answer = true;
		for (int i = 1; i < input.length(); i++) {
			char ch = input.charAt(i);
			if(ch != '1' && ch != '2'){
				answer = false;
				break;
			}
			if(bef == '1') {
				if(ch == '1') {
					answer = false;
					break;
				}
			}
			bef = ch;
		}
		System.out.println(answer);
	}
}

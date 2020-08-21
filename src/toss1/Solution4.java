package toss1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		String[] payWay = input.split(" ");
		for (int i = 0; i < payWay.length; i++) {
			StringBuilder output = new StringBuilder();
			int end = i-4>0?i-4:0;
			String cur = payWay[i];
			output.append(cur+ " ");
			for (int j = i-1; j >= end; j--) {
				String tmp = payWay[j];
				if(!output.toString().contains(tmp)) {
					output.append(tmp + " ");
				}else {
					if(end > 0) end--;
				}
			}
			System.out.println(output.toString().substring(0, output.length()-1));
		}
	}
}

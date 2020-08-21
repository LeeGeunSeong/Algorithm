package toss1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution7 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int pointer =Integer.parseInt(input.split(";")[0]);
		
		input = input.split(";")[1];
		String[] A = input.trim().split(" ");
		StringBuilder sb = new StringBuilder();
		int next = 0;
		int cnt = 0;
		sb.append("0; ");
		while(true) {
			int p = Integer.parseInt(A[pointer]);
			cnt++;
			if(p == 0) {
				next += 2;
				sb.append(0 + " " + next + " ");
				pointer = Integer.parseInt(A[pointer+1]);
			}else if(p == 1) {
				sb.append(1 + " " + A[pointer+1]+ " ");
				break;
			}
		}
		while(cnt++ < 4) {
			sb.append(0 + " " + 0 + " ");
		}
		System.out.println(sb.toString().substring(0,sb.length()-1));
	}
}

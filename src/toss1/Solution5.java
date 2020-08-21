package toss1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] kim = br.readLine().split(" ");
		String[] lee = br.readLine().split(" ");
		int N = kim.length;
		int change = 0;
		for (int i = 0; i < N; i++) {
			int tmpKim = Integer.parseInt(kim[i]);
			int tmpLee = Integer.parseInt(lee[i]);
			if(tmpKim > tmpLee + change) {
				System.out.print(tmpKim - change - tmpLee);
				change = 0;
			}else {
				change += tmpLee - tmpKim;
				System.out.print(0);
			}
			if(i < N-1) System.out.print(" ");
		}
	}
}

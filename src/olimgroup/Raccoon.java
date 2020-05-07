package olimgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Raccoon {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int[] raccoon = new int[input+1];
		raccoon[0] = 2;
		if(input >= 1) {
			raccoon[1] = 4;
			for (int i = 2; i <= input; i++) 
				raccoon[i] = raccoon[i-1] + raccoon[i-2];
		}
		System.out.println(raccoon[input]);
	}
}

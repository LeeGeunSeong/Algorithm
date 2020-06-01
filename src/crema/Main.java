package crema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> scores = new ArrayList<>();
		scores.add(20);
		scores.add(20);
		scores.add(20);
		scores.add(10);
		scores.add(10);
		System.out.println(sol1(2,scores));
	}

	private static int sol1(int k, List<Integer> scores) {
		Collections.sort(scores,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		int len = scores.size(), cur = scores.get(0);
		int rank = 1, i;
		for (i = 1; i < len; i++) {
			if(scores.get(i) == 0) {
				i--;
				break;
			}
			
			if(scores.get(i) != cur) {
				cur = scores.get(i);
				rank = i;
				if(++rank > k) break;
			}
		}
		
		return i;
	}
}

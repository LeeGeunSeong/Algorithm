package baemin;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Integer[] arr = {2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 2};
		sol1(arr);
	}

	private static int sol1(Integer[] arr) {
		ArrayList<Integer> list = null;
		int ans = 0;
		while(true) {
			ans++;
			int tmp = arr[0];
			int cnt = 1;
			list = new ArrayList<>();
			for (int i = 1; i < arr.length; i++) {
				if(arr[i] == tmp) {
					cnt++;
				}else {
					list.add(cnt);
					cnt = 1;
					tmp = arr[i];
				}
			}
			list.add(cnt);
			if(list.size() == 1) {
				if(list.get(0) != 1) ans++;
				break;
			}
			else arr = list.toArray(new Integer[list.size()]);
		}
		return ans;
	}
	
}

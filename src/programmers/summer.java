package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class summer {
	public static void main(String[] args) {
		int p = 1987;
		System.out.println(sol1(p));
		long n = 11;
		System.out.println(sol2(n));
		int[][] skills = 	{{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
		System.out.println(Arrays.toString(solution(121,skills)));
	}
	public static int[] solution(int total_sp, int[][] skills) {
        int[] answer = new int[skills.length+1];
        index = new int[skills.length+2];
        List[] list = new LinkedList[index.length];
        List[] up = new LinkedList[index.length];
        for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<Integer>();
			up[i] = new LinkedList<Integer>();
		}
        for (int i = 0; i < skills.length; i++) {
        	list[skills[i][0]].add(skills[i][1]);
        	up[skills[i][1]].add(skills[i][0]);
		}
        int root = 0;
        for (int i = 1; i < list.length; i++) {
        	if(list[i].size() == 0) index[i] = 1;
        	if(up[i].size() == 0) root = i;
		}
        dfs(root,list);
        System.out.println(Arrays.toString(index));
        int div = 0;
        for (int i = 1; i < index.length; i++) {
			div += index[i];
		}
        for (int i = 0; i < answer.length; i++) {
			answer[i] = index[i+1] * total_sp / div;
		}
        return answer;
    }
	static int[] index;
	private static int dfs(int idx, List[] list) {
		if(list[idx].size() == 0) {
			return index[idx];
		}
		for (int i = 0; i < list[idx].size(); i++) {
			index[idx] += dfs((int) list[idx].get(i),list);
		}
		return index[idx];
	}
	private static long sol2(long n) {
		long idx = 0;
		long tmp = n;
		List<Long> list = new ArrayList<Long>();
		while(tmp > 1) {
			tmp = tmp >>1;
			idx++;
		}
		if(n == Math.pow(2, idx)) {
			return (long) Math.pow(3, idx);
		}else {
			list.add((long) Math.pow(3, idx));
			for (int i = 0; i < idx; i++) {
				long temp = (long) Math.pow(3, i);
				list.add(list.get(0) + temp);
				for (int j = 1; j < Math.pow(2, i); j++) {
					list.add(list.get(j)+temp);
				}
			}
		}
		return list.get((int) (n-Math.pow(2, idx)));
	}

	private static int sol1(int p) {
		outer:
		for (int i = p+1;; i++) {
			String tmp = String.valueOf(i);
			Map<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < tmp.length(); j++) {
				if(map.containsKey(tmp.charAt(j))) continue outer;
				else map.put(tmp.charAt(j), 0);
			}
			return i;
		}
		
	}
	
}

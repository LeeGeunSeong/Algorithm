package dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		System.out.println(sol2("AM 12:10:10",172800));
		System.out.println(sol3(10,new int[][]{{1, 5},{2, 7},{4, 8},{3, 6}}));
		System.out.println(sol4(new String[]{"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"},2));
		System.out.println(sol4(new String[]{"AAD", "AAA", "AAC", "AAB"},4));
	}
	private static String sol4(String[] votes, int k) {
		String answer = "";
		Map<String, Integer> voteMap = new HashMap<>();
		for (int i = 0; i < votes.length; i++) {
			if(voteMap.get(votes[i]) == null) voteMap.put(votes[i], 1);
			else voteMap.put(votes[i], voteMap.get(votes[i])+1);
		}
		List<String> carList = new ArrayList<>(voteMap.keySet());
		
		Collections.sort(carList,((o1,o2) -> (voteMap.get(o2) - voteMap.get(o1) == 0?
											  o1.compareTo(o2):voteMap.get(o2) - voteMap.get(o1))));
		int limit = 0;
		for (int i = 0; i < k; i++) 
			limit += voteMap.get(carList.get(i));
		int sum = 0;
		for (int i = carList.size()-1; i >= 0; i--) {
			sum += voteMap.get(carList.get(i));
			if(sum >= limit) {
				answer = carList.get(i+1);
				break;
			}
		}
		return answer;
	}
	static int answer,totalcnt;
	static boolean[] bulb;
	private static int sol3(int n, int[][] groups) {
		answer = Integer.MAX_VALUE;
		bulb = new boolean[n];
		totalcnt = 0;
		Arrays.sort(groups,((o1,o2)->(o1[0]-o2[0]==0?o2[1]-o1[1]:o1[0]-o2[0])));
		turnOnBulb(n,0,0,groups);
		
		return answer;
	}

	private static void turnOnBulb(int n, int cnt, int bef, int[][] groups) {
		if(cnt >= groups.length) return;
		answer = Math.min(cnt + count(), answer);
		
		for (int i = bef; i < groups.length; i++) {
			int[] tmp = groups[i];
			boolean[] check = new boolean[n];
			for (int j = tmp[0]-1; j < tmp[1]; j++) {
				if(!bulb[j]) check[j] = true;
				bulb[j] = true;
			}
			turnOnBulb(n, cnt+1, bef+1, groups);
			for (int j = tmp[0]-1; j < tmp[1]; j++) 
				if(check[j]) bulb[j] = false;
		}
	}

	private static int count() {
		int ret = 0;
		for (int i = 0; i < bulb.length; i++) 
			if(!bulb[i]) ret++;
		
		return ret;
	}

	private static String sol2(String p, int n) {
		String answer = null;
		String meridiem = p.split(" ")[0];
		String[] time = p.split(" ")[1].split(":");
		int hour = Integer.parseInt(time[0]);
		int min = Integer.parseInt(time[1]);
		int sec = Integer.parseInt(time[2]) + n;
		if(meridiem.equals("PM") && hour != 12) hour += 12;
		if(meridiem.equals("AM") && hour == 12) hour -= 12;
		while(sec >= 60) {
			min++;
			sec -= 60;
		}
		while(min >= 60) {
			hour++;
			min -= 60;
		}
		while(hour >= 24) 
			hour -= 24;
		answer = (hour < 10?"0"+hour:hour) + ":" + (min < 10?"0"+min:min) + ":" + (sec < 10?"0"+sec:sec);  
		return answer;
	}
}

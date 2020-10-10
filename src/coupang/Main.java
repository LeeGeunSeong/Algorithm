package coupang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(sol1(14)));
//		System.out.println(sol2(3,new String[]{"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"}));
//		System.out.println(sol3(2, new int[] {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100}));
		System.out.println(sol4("SEOUL","DAEGU","YEOSU",new String[][] {{"ULSAN","BUSAN"},
																		{"DAEJEON","ULSAN"},
																		{"DAEJEON","GWANGJU"},
																		{"SEOUL","DAEJEON"},
																		{"SEOUL","ULSAN"},
																		{"DAEJEON","DAEGU"},
																		{"GWANGJU","BUSAN"},
																		{"DAEGU","GWANGJU"},
																		{"DAEGU","BUSAN"},
																		{"ULSAN","DAEGU"},
																		{"GWANGJU","YEOSU"},
																		{"BUSAN","YEOSU"}}));
	}
	// 출발지 depar, 물류센터 hub, 배송지 dest, 도로정보 roads
	// depar -> hub -> dest 로 가는 경로의 개수를 10007로 나눈 나머지 return
	// 문자열 길이 1 <= depar,hub,dest <= 10, 알파벳 대문자, 서로 다름
	// roads의 길이 1~ 100000 s1 -> s2로 가는 단방향 도로
	// cycle x
	/////////////////////////////////////////////////////////////////////////////////////////////////// 4번
	static class Truck{
		int curPos;
		boolean isVisitedHub;
		public Truck(int curPos, boolean isVisitedHub) {
			super();
			this.curPos = curPos;
			this.isVisitedHub = isVisitedHub;
		}
		@Override
		public String toString() {
			return "Truck [curPos=" + curPos + ", isVisitedHub=" + isVisitedHub + "]";
		}
		
	}
	private static int sol4(String depar, String hub, String dest, String[][] roads) {
		int answer = 0;
		Set<String> cities = new HashSet<>();
		for (int i = 0; i < roads.length; i++) 
			for (int j = 0; j < 2; j++) 
				cities.add(roads[i][j]);
		
		Map<String, Integer> indexMap = new HashMap<>();
		int idx = 0;
		for (String city : cities) 
			indexMap.put(city, idx++);
		
		List<List<Integer>> roadList = new ArrayList<List<Integer>>();
		int numOfCities = cities.size();
		
		for (int i = 0; i < numOfCities; i++) 
			roadList.add(new ArrayList<Integer>());
			
		for (int i = 0; i < roads.length; i++) {
			String s = roads[i][0];
			String e = roads[i][1];
			roadList.get(indexMap.get(s)).add(indexMap.get(e));
		}
		
		int idxHub = indexMap.get(hub);
		int idxDest = indexMap.get(dest);
		Queue<Truck> q = new LinkedList<>();
		q.offer(new Truck(indexMap.get(depar),false));
		
		while(!q.isEmpty()) {
			Truck cur = q.poll();
			if(cur.curPos == idxHub) cur.isVisitedHub = true;
			if(cur.curPos == idxDest && cur.isVisitedHub) {
				answer++;
				continue;
			}
			for (int next : roadList.get(cur.curPos)) {
				q.offer(new Truck(next,cur.isVisitedHub));
			}
		}
		return answer%10007;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////// 3번
	private static int sol3(int k, int[] score) {
		int answer = 0;
		int len = score.length;
		
		int[] dp = new int[len];
		List<Integer> manipulList = new ArrayList<>();
		Map<Integer, Integer> countMap = new HashMap<>();
		
		for (int i = 1; i < len; i++) {
			dp[i] = score[i-1] - score[i];
			if(countMap.get(dp[i]) == null) countMap.put(dp[i], 1);
			else countMap.put(dp[i], countMap.get(dp[i])+1);
		}
		
		for (Integer key : countMap.keySet()) {
			if(countMap.get(key) >= k) 
				manipulList.add(key);
		}
		
		boolean[] isManipulated = new boolean[len];
		
		for (int i = 1; i < len; i++) {
			if(manipulList.contains(dp[i])) 
				isManipulated[i-1] = isManipulated[i] = true;
		}
		
		for (int i = 0; i < len; i++) 
			if(!isManipulated[i]) answer++;
		
		return answer;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////// 2번
	
	static class Person{
		String arrDay, arrTime;
		int time;
		public Person(String arrDay, String arrTime, int time) {
			super();
			this.arrDay = arrDay;
			this.arrTime = arrTime;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Person [arrDay=" + arrDay + ", arrTime=" + arrTime + ", time=" + time + "]";
		}
	}
	static class Kiosk{
		int id, numOfMatching;
		String exitTime;
		boolean isUsed;
		public Kiosk(int id, int numOfMatching, String exitTime, boolean isUsed) {
			super();
			this.id = id;
			this.numOfMatching = numOfMatching;
			this.exitTime = exitTime;
			this.isUsed = isUsed;
		}
		@Override
		public String toString() {
			return "Kiosk [id=" + id + ", numOfMatching=" + numOfMatching + ", exitTime=" + exitTime + ", isUsed="
					+ isUsed + "]";
		}
	}
	private static int sol2(int n, String[] customers) {
		int answer = 0;
		List<Person> customerList = new ArrayList<>();
		for (int i = 0; i < customers.length; i++) {
			String[] tmp = customers[i].split(" ");
			customerList.add(new Person(tmp[0],tmp[1],Integer.parseInt(tmp[2])));
		}
		PriorityQueue<Kiosk> pq = new PriorityQueue<>((o1,o2)->(Boolean.compare(o1.isUsed, o2.isUsed)==0?
																o1.exitTime.compareTo(o2.exitTime)==0?
																o1.id-o2.id:
																o1.exitTime.compareTo(o2.exitTime):
																Boolean.compare(o1.isUsed, o2.isUsed)));
		
		for (int i = 0; i < n; i++) 
			pq.offer(new Kiosk(i,0, "0", false));
		
		for (Person p : customerList) {
			Kiosk k = pq.poll();
			pq.offer(new Kiosk(k.id,k.numOfMatching+1, getExitTime(k,p), true));
		}
		while(!pq.isEmpty()) 
			answer = Math.max(answer, pq.poll().numOfMatching);
		
		return answer;
	}

	private static String getExitTime(Kiosk k, Person p) {
		String[] tmpDay = new String[2];
		String[] tmpTime = new String[3];
		if(k.isUsed) {
			String[] tmp = k.exitTime.split(" ");
			tmpDay = tmp[0].split("/");
			tmpTime = tmp[1].split(":");
			k.isUsed = checkIsUsed(k,p);
		}
		if(!k.isUsed){
			tmpDay = p.arrDay.split("/");
			tmpTime = p.arrTime.split(":");
		}
		int month = Integer.parseInt(tmpDay[0]);
		int day = Integer.parseInt(tmpDay[1]);
		int hour = Integer.parseInt(tmpTime[0]);
		int min = Integer.parseInt(tmpTime[1]) + p.time;
		int sec = Integer.parseInt(tmpTime[2]);
		if(min >= 60) {
			hour++;
			min -= 60;
		}
		if(hour >= 24) {
			hour = 0;
			day++;
			if((day > 31) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || 
					month == 10 || month == 12)) {
				month++;
				day = 1;
			}else if(day > 28 && month == 2) {
				day = 1; month++;
			}else if((day > 30) && (month == 4 && month == 6 && month == 9 && month == 11)) {
				day = 1; month++;
			}
		}
		String arrDay = (month<10?"0"+month:month) + "/" + (day<10?"0"+day:day);
		String arrTime = (hour<10?"0"+hour:hour) + ":" + (min<10?"0"+min:min) + ":" + (sec<10?"0"+sec:sec);
		String exitTime = arrDay + " " + arrTime;
		return exitTime;
	}

	private static boolean checkIsUsed(Kiosk k, Person p) {
		String[] tmp = k.exitTime.split(" ");
		if(tmp[0].split("/")[0].compareTo(p.arrDay.split("/")[0]) < 0) return false;
		if(tmp[0].split("/")[1].compareTo(p.arrDay.split("/")[1]) < 0) return false;
		if(tmp[1].split(":")[0].compareTo(p.arrTime.split(":")[0]) < 0) return false;
		if(tmp[1].split(":")[1].compareTo(p.arrTime.split(":")[1]) < 0) return false;
		if(tmp[1].split(":")[2].compareTo(p.arrTime.split(":")[2]) < 0) return false;
		return true;
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////// 1번
	private static int[] sol1(int N) {
		int[] answer = new int[2];
		for (int k = 2; k <= 10; k++) {
			int tmp = N;
			int mul = 1;
			
			while(tmp > 1) {
				mul *= tmp%k;
				tmp /= k;
			}
			if(mul >= answer[1]) {
				answer[1] = mul;
				answer[0] = k;
			}
		}
		return answer;
	}
}

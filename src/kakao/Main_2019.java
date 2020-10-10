package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main_2019 {
	public static void main(String[] args) {
		String hand = "left";
//		int input = 0;
		int[] input = {7,0,8,2,8,3,1,5,7,6,2};
//		String exp = "50*6-3*2";
		String exp = "100-200*300-500+20";
		String[] gem = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//		String[] gem = {"AA", "AB", "AC", "AA", "AC"};
//		String[] gem = {"XYZ", "XYZ", "XYZ"};
		int[][] board = {{0,0,0,0,0,0,0,1}
						,{0,0,0,0,0,0,0,0}
						,{0,0,0,0,0,1,0,0}
						,{0,0,0,0,1,0,0,0}
						,{0,0,0,1,0,0,0,1}
						,{0,0,1,0,0,0,1,0}
						,{0,1,0,0,0,1,0,0}
						,{1,0,0,0,0,0,0,0}};
//		System.out.println(sol1(input,hand));
//		System.out.println(sol2(exp));
//		System.out.println(Arrays.toString(sol3(gem)));
//		System.out.println(sol4(board));
		int N = 9;
		int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
//		int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		int[][] order = {{4,1},{8,5},{6,7}};
		System.out.println(sol5(N,path,order));
	}

	private static boolean sol5(int n, int[][] path, int[][] order) {
		boolean ans = true;
		List<Integer>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) 
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < path.length; i++) {
			list[path[i][0]].add(path[i][1]);
			list[path[i][1]].add(path[i][0]);
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		boolean[] visited = new boolean[n];
		boolean[] v = new boolean[order.length];
		visited[0] = true;
		int cnt = 0, tmp = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			ans = true;
			for (int i = 0; i < n; i++) {
				if(!visited[i]) ans = false;
			}
			if(ans) return ans;
			outer:
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(visited[next]) continue;
				for (int j = 0; j < order.length; j++) {
					if(v[j]) continue;
					if(next == order[j][0]) v[j] = true;
					if(next == order[j][1] && !v[j]) {
						q.offer(cur);
						if(tmp == cur && cnt > 100) return ans;
						if(tmp != cur) cnt = 0;
						tmp = cur;
						cnt++;
						continue outer;
					}
				}
				q.offer(next);
				visited[next] = true;
			}
		}
		return ans;
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	private static int sol4(int[][] board) {
		int answer = 100000000;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		int N = board.length;
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) 
			Arrays.fill(dist[i], 1000000000);
		
		pq.offer(new int[] {0,0,0,1});
		pq.offer(new int[] {0,0,0,2});
		dist[0][0] = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int val = cur[2];
			int dir = cur[3];
			if(x == N-1 && y == N-1) 
				answer = Math.min(answer, val);
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx >= 0 && ny >= 0 && nx <= N-1 && ny <= N-1 && dist[nx][ny] >= val+100 && board[nx][ny] == 0) {
				pq.offer(new int[] {nx,ny,val+100,dir});
				dist[nx][ny] = val+100;
			}
			for (int i = 1; i <= 3; i+= 2) {
				int newDir = (dir+i)%4;
				nx = x + dx[newDir];
				ny = y + dy[newDir];
				if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 
						|| board[nx][ny] == 1) continue;
				if(dist[nx][ny] >= val+600) {
					pq.offer(new int[] {nx,ny,val+600,newDir});
					dist[nx][ny] = val+600;
				}
			}
		}
        return answer;
	}

//	private static int[] sol3(String[] gems) {
//		int[] ans = new int[2];
//		Set<String> gemCountSet = new HashSet<>();
//		for (int i = 0; i < gems.length; i++) {
//			gemCountSet.add(gems[i]);
//		}
//		int gemCount = gemCountSet.size();
//		Map<String, Integer> map = new HashMap<>();
//		ArrayList<int[]> pair = new ArrayList<>();
//		int l = 0, r = 0;
//		while(r < gems.length) {
//			if(map.size() < gemCount) 
//				map.put(gems[r], r++);
//			if(map.size() == gemCount) {
//				int min = Collections.min(map.values());
//				map.remove(gems[min]);
//				l = min +1;
//				pair.add(new int[] {l,r});
//			}
//		}
//		Collections.sort(pair, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				int diff1 = o1[1]-o1[0];
//				int diff2 = o2[1]-o2[0];
//				return diff1-diff2==0?o1[0]-o2[0]:diff1-diff2;
//			}
//		});
//		ans[0] = pair.get(0)[0];
//		ans[1] = pair.get(0)[1];
//        return ans;
//	}

	private static long sol2(String expression) {
		long ans = 0;
		opCountArray = new int[3];
		String numStr = "";
		numList = new ArrayList<>();
		opList = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char tmp = expression.charAt(i);
			if(tmp =='*' || tmp=='+' || tmp=='-') {
				if(tmp=='*') opCountArray[0]++;
				else if(tmp=='+') opCountArray[1]++;
				else if(tmp== '-') opCountArray[2]++;
				opList.add(tmp);
				numList.add(Long.parseLong(numStr));
				numStr = "";
			}else numStr += tmp;
		}
		numList.add(Long.parseLong(numStr));
		opCount = 0;
		max = 0;
		for (int i = 0; i < 3; i++) 
			if(opCountArray[i] > 0) opCount++;
		
		v = new boolean[3];
		prior = new int[opCount];
		solve(0);
		ans = max;
		return ans;
	}
	static ArrayList<Long> numList;
	static ArrayList<Character> opList;
	static int opCount;
	static int[] prior,opCountArray;
	static boolean[] v;
	static long max;
	private static void solve(int cnt) {
		if(cnt == opCount) {
			max = Math.max(max, calc());
			return;
		}
		for (int i = 0; i < 3; i++) {
			if(v[i] || opCountArray[i] == 0) continue;
			prior[cnt] = i;
			v[i] = true;
			solve(cnt+1);
			v[i] = false;
		}
	}

	private static long calc() {
		List<Long> tmpNumList = new ArrayList<>();
		List<Character> tmpOpList = new ArrayList<>();
		tmpNumList.addAll(numList);
		tmpOpList.addAll(opList);
		int index = 0;
		Long ret = 0L;
		while(tmpNumList.size() > 1) {
			char op = prior[index]==0?'*':prior[index]==1?'+':'-'; 
			int idx = tmpOpList.indexOf(op);
			while(true) {
				if(idx < 0) {
					index++;
					break;
				}
				ret = tmpNumList.get(idx);
				switch (op) {
				case '*':  ret *= tmpNumList.get(idx+1);
				break;
				case '+': ret += tmpNumList.get(idx+1);
				break;
				case '-': ret -= tmpNumList.get(idx+1);
				break;
				default:
					break;
				}
				tmpOpList.remove(idx);
				tmpNumList.remove(idx+1);
				tmpNumList.set(idx, ret);
				idx = tmpOpList.indexOf(op);
			}
		}
		
		return Math.abs(ret);
	}

	private static String sol1(int[] numbers, String hand) {
		String ans = "";
		StringBuilder sb = new StringBuilder();
		int[] posL = {3,0},posR = {3,2};
		for (int i = 0; i < numbers.length; i++) {
			int tmpNum = numbers[i];
			if(tmpNum%3 == 1) { // 왼
				sb.append("L");
				posL[0] = tmpNum/3;
				posL[1] = 0;
			}else if (tmpNum > 0 && tmpNum%3 == 0) { // 오
				sb.append("R");
				posR[0] = tmpNum/3-1;
				posR[1] = 2;
			}else { // 가운데
				int[] curPos = new int[2];
				curPos[0] = tmpNum==0?3:tmpNum/3;
				curPos[1] = 1;
				int distL = Math.abs(getDist(curPos,posL));
				int distR = Math.abs(getDist(curPos,posR));
				if(distL==distR) {
					if(hand.equals("left")) {
						sb.append("L");
						posL[0] = curPos[0];
						posL[1] = curPos[1];
					}
					else {
						sb.append("R");
						posR[0] = curPos[0];
						posR[1] = curPos[1];
					}
				}else if(distL < distR) {
					sb.append("L");
					posL[0] = curPos[0];
					posL[1] = curPos[1];
				}else {
					sb.append("R");
					posR[0] = curPos[0];
					posR[1] = curPos[1];
				}
			}
		}
		ans = sb.toString();
		return ans;
	}

	private static int getDist(int[] curPos, int[] posL) {
		int ret = 0;
		ret += Math.abs(curPos[0]-posL[0]);
		ret += Math.abs(curPos[1]-posL[1]);
		return ret;
	}
}

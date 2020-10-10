package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main_2020 {
	public static void main(String[] args) {
		
//		System.out.println(sol1("abcdefghijklmn.p"));
//		System.out.println(sol2(new String[]{"XYZ", "XWY", "WXA"}, 
//					new int[]{2,3,4}));
//		System.out.println(sol3(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}
//		, new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}));
//		System.out.println(sol4(6,4,5,6,new int[][] {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
		System.out.println(sol5("02:03:55","00:14:15", 
				new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "00:30:59-01:53:29", "01:37:44-02:02:30"}));
		System.out.println(sol6(new int[][] {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}, 1, 0));
	}

	// 알파벳 소문자, 숫자, -, _, .(처음과 끝 사용 불가, 연속 사용불가) 만 사용가능
	private static String sol1(String new_id) {
		String answer = "";
		new_id = new_id.toLowerCase();
		String reg = "[^0-9a-z-_.\\s]";
		new_id = new_id.replaceAll(reg, "");
		while(new_id.indexOf("..") != -1) 
			new_id = new_id.replace("..", ".");
		
		if(new_id.charAt(0) == '.') 
			new_id = new_id.substring(1);
		
		if(new_id.length() > 0 
				&& new_id.charAt(new_id.length()-1) == '.') 
			new_id = new_id.substring(0,new_id.length()-1);
		
		if(new_id.length() == 0) 
			new_id += 'a';
		
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0,15);
			if(new_id.charAt(14) == '.') new_id = new_id.substring(0,14);
		}
		
		while(new_id.length() < 3) 
			new_id += new_id.charAt(new_id.length()-1);
		
		return answer = new_id;
	}
	static Map<String, Integer> map = new HashMap<>();
	private static String[] sol2(String[] orders, int[] course) {
		String[] answer = {};
		for (int i = 0; i < orders.length; i++) {
			orders[i] = sortOrder(orders[i]);
			findCombi(0, orders[i], "");
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet, (o1,o2) -> 
						(o1.length()==o2.length()?map.get(o2)-map.get(o1):o1.length()-o2.length()));
		
		int[] idx = new int[keySet.get(keySet.size()-1).length()+1];
		ArrayList<String> ansList = new ArrayList<String>();
		int tmpIdx = 0;
		for (int i = 2; i < idx.length; i++) {
			for (int j = tmpIdx; j < keySet.size(); j++) {
				if(i == keySet.get(j).length()) {
					idx[i] = j;
					break;
				}
			}
		}
		for (int i = 0; i < course.length; i++) {
			int curCourse = course[i]; // 오름차순
			if(curCourse > keySet.get(keySet.size()-1).length()) break;
			int index = idx[curCourse];
			int max = map.get(keySet.get(index));
			if(max == 1) {
				continue;
			}
			while(curCourse == keySet.get(index).length()) {
				if(max > map.get(keySet.get(index))) break;
				
				ansList.add(keySet.get(index++));
			}
		}
		Collections.sort(ansList);
		answer = ansList.toArray(new String[ansList.size()]);
		return answer;
	}
	private static String sortOrder(String order) {
		char[] chArr = order.toCharArray();
		char tmp;
		for (int i = 0; i < chArr.length-1; i++) {
			for (int j = i+1; j < chArr.length; j++) {
				if(chArr[i] > chArr[j]) {
					tmp = chArr[i];
					chArr[i] = chArr[j];
					chArr[j] = tmp;
				}
			}
		}
		String ret = "";
		for (int i = 0; i < chArr.length; i++) 
			ret += chArr[i];
		return ret;
	}
	private static void findCombi(int cnt, String order, String combi) {
		if(cnt == order.length()) {
			if(combi.length() < 2) return;
			if(map.get(combi) == null) map.put(combi, 1);
			else map.put(combi, map.get(combi)+1);
			return;
		}
		findCombi(cnt+1, order, combi + order.charAt(cnt));
		findCombi(cnt+1, order, combi);
	}
	private static int[] sol3(String[] info, String[] query) {
		List<Integer> ansList = new ArrayList<>();
		List<Integer>[][][][] list = new ArrayList[3][2][2][2];
		int a,b,c,d;
		for (a = 0; a < 3; a++) 
			for (b = 0; b < 2; b++) 
				for (c = 0; c < 2; c++) 
					for (d = 0; d < 2; d++) 
						list[a][b][c][d] = new ArrayList<>();
		
		for (int i = 0; i < info.length; i++) {
			String[] curInfo = info[i].split(" ");
			if(curInfo[0].equals("cpp")) a = 0;
			else if(curInfo[0].equals("java")) a = 1;
			else a = 2;
			
			if(curInfo[1].equals("frontend")) b = 0;
			else b = 1;
			
			if(curInfo[2].equals("junior")) c = 0;
			else c = 1;
			
			if(curInfo[3].equals("chicken")) d = 0;
			else d = 1;
			
			list[a][b][c][d].add(Integer.valueOf(curInfo[4]));
		}
		
		for (a = 0; a < 3; a++) 
			for (b = 0; b < 2; b++) 
				for (c = 0; c < 2; c++) 
					for (d = 0; d < 2; d++) 
						Collections.sort(list[a][b][c][d]);
		
		for (int i = 0; i < query.length; i++) {
			String[] condition = query[i].split(" and ");
			int limit = Integer.valueOf(condition[3].split(" ")[1]);
			condition[3] = condition[3].split(" ")[0];
			int sum = 0;
			
			if(condition[0].equals("cpp")) a = 0;
			else if(condition[0].equals("java")) a = 1;
			else if(condition[0].equals("python")) a = 2;
			else a = -1;
			
			if(condition[1].equals("frontend")) b = 0;
			else if(condition[1].equals("backend")) b = 1;
			else b = -1;
			
			if(condition[2].equals("junior")) c = 0;
			else if(condition[2].equals("senior")) c = 1;
			else c = -1;
			
			if(condition[3].equals("chicken")) d = 0;
			else if(condition[3].equals("pizza")) d = 1;
			else d = -1;
			
			for (int j = 0; j < 3; j++) {
				if(a != j && a != -1) continue;
				for (int k = 0; k < 2; k++) {
					if(b != k && b != -1) continue;
					for (int l = 0; l < 2; l++) {
						if(c != l && c != -1) continue;
						for (int m = 0; m < 2; m++) {
							if(d != m && d != -1) continue;
							List<Integer> tmpList = list[j][k][l][m];
							int size = tmpList.size();
							int mid;
							int start = 0, end = size;
							while(start < end) {
								mid = (start + end)/2;
								if(tmpList.get(mid) < limit) start = mid + 1;
								else end = mid;
							}
							sum += size - end;
						}
					}
				}
			}
			ansList.add(sum);
		}
		int[] answer = new int[ansList.size()];
		for (int i = 0; i < ansList.size(); i++) 
			answer[i] = ansList.get(i);
		
		return answer;
	}
	private static int sol4(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;
		int INF = 100000000;
		int[][] adjMap = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= n; j++) 
				adjMap[i][j] = INF;
		
		for (int i = 1; i <= n; i++) 
			adjMap[i][i] = 0;
		for (int i = 0; i < fares.length; i++) {
			adjMap[fares[i][0]][fares[i][1]] = fares[i][2];
			adjMap[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(i==k) continue;
				for (int j = 1; j <= n; j++) {
					if(j==k) continue;
					if(adjMap[i][k] + adjMap[k][j] < adjMap[i][j])
						adjMap[i][j] = adjMap[i][k] + adjMap[k][j]; 
				}
			}
		}
		answer = adjMap[s][a] + adjMap[s][b];
		for (int i = 1; i <= n; i++) {
			if(i == s) continue;
			int tmp = adjMap[s][i] + adjMap[i][a] + adjMap[i][b];
			answer = Math.min(answer, tmp);
		}
		return answer;
	}
	private static String sol5(String play_time, String adv_time, String[] logs) {
        String[] playTime = play_time.split(":");
        String[] advTime = adv_time.split(":");
        
        int playSize = Integer.valueOf(playTime[0]) * 3600 
        		+ Integer.valueOf(playTime[1]) * 60 
        		+ Integer.valueOf(playTime[2]);
        
        int advSize = Integer.valueOf(advTime[0]) * 3600 
        		+ Integer.valueOf(advTime[1]) * 60 
        		+ Integer.valueOf(advTime[2]);

        if(playSize==advSize) return "00:00:00";
        int[] timeStamp = new int[playSize];

        for (int i = 0; i < logs.length; i++) {
        	String[] info = logs[i].split("-");
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");

            int s = Integer.valueOf(start[0]) * 3600 
            		+ Integer.valueOf(start[1]) * 60 
            		+ Integer.valueOf(start[2]);
            
            int e = Integer.valueOf(end[0]) * 3600 
            		+ Integer.valueOf(end[1]) * 60 
            		+ Integer.valueOf(end[2]);
            
            for (int j = s; j < e; j++)
            	timeStamp[j]++;
	    }
        
        long time = 0, max = 0;
        
        for (int i = 0; i < advSize; i++) 
        	time += timeStamp[i];
        
        max = time;
        int sec = 0;
        for (int i = 1; i < playSize-advSize+1; i++) {
            time += timeStamp[advSize+i-1]-timeStamp[i-1];
            if(time > max) {
            	max = time;
				sec = i;
            }
        }
        StringBuilder sb = new StringBuilder();
		sb.append((sec/3600<10?"0"+sec/3600:sec/3600) + ":");
		sec %= 3600;
		sb.append((sec/60<10?"0"+sec/60:sec/60) + ":");
		sec %= 60;
		sb.append(sec<10?"0"+sec:sec);
		
        return sb.toString();
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] v;
	static int ans;
	private static int sol6(int[][] board, int r, int c) {
		int answer = 0;
		v = new boolean[4][4];
		v[r][c] = true;
		ans = 100000;
		dfs(board,r,c,1,-1);
		return answer;
	}

	private static void dfs(int[][]board, int x, int y, int cnt, int bef) {
		if(check(board)) {
			ans = Math.min(ans, cnt);
			return ;
		}
		int nx,ny;
		int val = board[x][y];
		for (int dir = 0; dir < 4; dir++) {
			if(bef==dir || bef == (dir+2)%4) continue;
			nx = x;
			ny = y;
			while(true) {
				nx += dx[dir];
				ny += dy[dir];
				if(nx < 0 || ny < 0 || nx > 3 || ny > 3) {
					nx -= dx[dir];
					ny -= dy[dir];
					break;
				}
				if(board[nx][ny] > 0) {
					if(board[nx][ny] == val) {
						board[x][y] = 0;
						board[nx][ny] = 0;
						dfs(board, nx, ny, cnt+2,dir);
						board[x][y] = val;
						board[nx][ny] = val;
					}else if(val == 0){
						dfs(board, nx, ny, cnt+1, dir);
					}
					break;
				}
			}
			if(x==nx && y==ny) continue;
			board[x][y] = 0;
			board[nx][ny] = val;
			dfs(board, nx, ny, cnt+1,dir);
			board[x][y] = val;
			board[nx][ny] = 0;
		}
	}

	private static boolean check(int[][] board) {
		for (int i = 0; i < 4; i++) 
			for (int j = 0; j < 4; j++) 
				if(board[i][j] > 0) return false;
		return true;
	}
}

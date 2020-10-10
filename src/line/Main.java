package line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		System.out.println(sol1(new int[][] {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}}));
		System.out.println(Arrays.toString(sol2(new int[]{11, 2, 9, 13, 24}, new int[] {9, 2, 13, 24, 11})));
		System.out.println(Arrays.toString(sol3(73425)));
		System.out.println(sol4(new int[][] {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}}));
		System.out.println(sol5(new int[] {10, 13, 10, 1, 2, 3, 4, 5, 6, 2}));
		System.out.println(Arrays.toString(sol6(new String[] {"A abc 2", "B abc 1"}, new String[] {"a AB 1", "b AB 1", "c AB 1"})));
	}
	private static String[] sol6(String[] companies, String[] applicants) {
		List<Character>[] company = new ArrayList[companies.length];
		Map<Character, Integer> appl_limit = new HashMap<>();
		for (int i = 0; i < company.length; i++) 
			company[i] = new ArrayList<>();
		boolean[] v = new boolean[applicants.length];
		for (int i = 0; i < applicants.length; i++) {
			String[] info = applicants[i].split(" ");
			char applicant = info[0].charAt(0);
			int limit = Integer.valueOf(info[2]);
			appl_limit.put(applicant, limit);
		}
		while(true) {
			boolean flag = false;
			for (int i = 0; i < applicants.length; i++) {
				String[] info = applicants[i].split(" ");
				char applicant = info[0].charAt(0);
				String com_rank = info[1];
				int limit = Integer.valueOf(info[2]);
				int count = appl_limit.get(applicant);
				if(count == 0 || v[applicant-'a']) continue;
				appl_limit.put(applicant, appl_limit.get(applicant)-1);
				company[com_rank.charAt(limit-count)-'A'].add(applicant);
				flag = true;
			}
			if(!flag) break;
			for (int i = 0; i < company.length; i++) {
				String[] info = companies[i].split(" ");
				char com = info[0].charAt(0);
				String app_rank = info[1];
				int limit = Integer.valueOf(info[2]);
				
				while(company[com-'A'].size() > limit) {
					List<Character> tmpList = new ArrayList<>();
					for (int j = 0; j < app_rank.length(); j++) {
						char appl = app_rank.charAt(j);
						if(company[com-'A'].contains(appl)) {
							tmpList.add(appl);
							company[com-'A'].remove(company[com-'A'].indexOf(appl));
						}
						if(tmpList.size() == limit) break;
					}
					company[com-'A'] = new ArrayList<>();
					company[com-'A'].addAll(tmpList);
				}
			}
			Arrays.fill(v, false);
			for (List<Character> list : company) 
				for (Character ch : list) 
					v[ch-'a'] = true;
		}
		String[] answer = new String[companies.length];
		for (int i = 0; i < answer.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(Character.valueOf((char) ('A' + i)) + "_");
			String chStr = "";
			for (Character ch : company[i]) 
				chStr += ch;
			sb.append(sort(chStr));
			
			answer[i] = sb.toString();
		}
		return answer;
	}
	private static String sort(String str) {
		char[] chArr = str.toCharArray();
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
	private static int sol5(int[] cards) {
		int answer = 0;
		int idx = 0;
		int[] player = new int[2]; 
		int[] dealer = new int[2];
		outer:
		while(idx < cards.length) {
			player[0] = cards[idx]>10?10:cards[idx];
			idx++;
			dealer[0] = cards[idx]>10?10:cards[idx];
			idx++;
			player[1] = cards[idx]>10?10:cards[idx];
			idx++;
			dealer[1] = cards[idx]>10?10:cards[idx];
			idx++;
			int sum_player = player[0] + player[1];
			int sum_dealer = dealer[0] + dealer[1];
			if(sum_player == 21 || (sum_player == 11 && (player[0] == 1 || player[1] == 1))) {
				if(sum_dealer == 21) continue;
				else answer +=3;
			}else if(sum_player < 21) {
				int min_dealer = Math.min(dealer[0], dealer[1]);
				int max_dealer = Math.max(dealer[0], dealer[1]);
				// 플레이어 카드 받기
				if(min_dealer==1 || max_dealer >= 7) {
					while(sum_player < 17) {
						if((player[0] == 1 || player[1] == 1) && sum_player <= 11) {
							sum_player += 10;
							if(sum_player >= 17) break;
						}
						if(idx >= cards.length) break outer;
						if(cards[idx] == 1 && sum_player >= 6 && sum_player <= 10) 
							sum_player += 10;
						sum_player += cards[idx++];
						if(sum_player > 21) {
							answer -= 2;
							continue outer;
						}
					}
				}else if((dealer[0] >= 4 && dealer[0] <= 6) || (dealer[1] >= 4 && dealer[1] <= 6)) {
					// stop
				}else if ((dealer[0] >= 2 && dealer[0] <= 3) || (dealer[1] >= 2 && dealer[1] <= 3)) {
					while(sum_player < 12) {
						if((player[0] == 1 || player[1] == 1) && sum_player <= 11) {
							sum_player += 10;
							if(sum_player >= 12) break;
						}
						if(idx >= cards.length) break outer;
						if(cards[idx] == 1 && sum_player <= 10) 
							sum_player += 10;
						sum_player += cards[idx++];
						if(sum_player > 21) {
							answer -= 2;
							continue outer;
						}
					}
				}
				// 딜러 카드 받기
				while(sum_dealer < 17) {
					if((dealer[0] == 1 || dealer[1] == 1) && sum_dealer <= 11) {
						sum_dealer += 10;
						if(sum_dealer >= 17) break;
					}
					if(idx >= cards.length) break outer;
					if(cards[idx] == 1 && sum_player >= 6 && sum_player <= 10) 
						sum_dealer += 10;
					sum_dealer += cards[idx++];
					if(sum_dealer > 21) {
						answer += 2;
						continue outer;
					}
				}
				if(sum_player > sum_dealer) answer += 2;
				else if(sum_player < sum_dealer) answer -= 2;
			}else {
				answer -= 2;
				continue;
			}
		}
		
		
		return answer;
	}
	static class Person{
		int x,y;
		int sec, dir;
		public Person(int x, int y, int sec, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.sec = sec;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", sec=" + sec + ", dir=" + dir + "]";
		}
		
	}
	private static int sol4(int[][] maze) {
		int answer = 0;
		int n = maze.length;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		Queue<Person> q = new LinkedList<>();
		if(maze[0][1] == 1) q.offer(new Person(0,0,0,0));
		else if(maze[1][0] == 1) q.offer(new Person(0,0,0,1));
		else {
			q.offer(new Person(0,0,0,0));
			q.offer(new Person(0,0,0,1));
		}
		
		while(!q.isEmpty()) {
			Person cur = q.poll();
			if(cur.x == n-1 && cur.y == n-1) {
				answer = cur.sec;
				break;
			}
			int dir = (cur.dir+1)%4;
			int nx = cur.x + dx[dir];
			int ny = cur.y + dy[dir];
			if(nx < 0 || ny < 0 || nx > n-1 || ny > n-1 || maze[nx][ny]==1) {
				dir = cur.dir;
				nx = cur.x + dx[dir];
				ny = cur.y + dy[dir];
				while(nx < 0 || ny < 0 || nx > n-1 || ny > n-1 || maze[nx][ny] == 1) {
					dir = dir==0?3:dir-1;
					nx = cur.x + dx[dir];
					ny = cur.y + dy[dir];
				}
			}
			q.offer(new Person(nx,ny,cur.sec+1,dir));
		}
		
		return answer;
	}
	static int min_cnt, value;
	private static int[] sol3(int n) {
		int[] answer = new int[2];
		min_cnt = 10000000;
		sum_num(n,0);
		answer[0] = min_cnt;
		answer[1] = value;
		return answer;
	}

	private static void sum_num(int n, int cnt) {
		if(n < 10) {
			min_cnt = Math.min(cnt, min_cnt);
			value = n;
			return;
		}
		if(cnt > min_cnt) return ;
		String num = String.valueOf(n);
		for (int i = 1; i < num.length(); i++) {
			if(num.substring(i, num.length()).charAt(0) == '0') continue;
			int tmp = Integer.valueOf(num.substring(0,i)) + Integer.valueOf(num.substring(i,num.length()));
			sum_num(tmp, cnt+1);
		}
	}
	private static int[] sol2(int[] ball, int[] order) {
		List<Integer> ansList = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		List<Integer> hold_list = new ArrayList<>();
		for (int i = 0; i < ball.length; i++) 
			deque.addFirst(ball[i]);
		
		for (int i = 0; i < order.length; i++) {
			int cur_order = order[i];
			
			if(deque.peekFirst() == cur_order || deque.peekLast() == cur_order) {
				if(deque.peekFirst() == cur_order) ansList.add(deque.pollFirst());
				else ansList.add(deque.pollLast());
				
				for (int j = 0; j < hold_list.size(); j++) {
					int cur_hold = hold_list.get(j);
					
					if(deque.peekFirst() == cur_hold) {
						ansList.add(deque.pollFirst());
						hold_list.remove(j);
						j = -1;
					}else if(deque.peekLast() == cur_hold){
						ansList.add(deque.pollLast());
						hold_list.remove(j);
						j = -1;
					}
				}
			}else hold_list.add(cur_order);
		}
		
		int[] answer = new int[ansList.size()];
		for (int i = 0; i < answer.length; i++) 
			answer[i] = ansList.get(i);
		
		return answer;
	}

	private static int sol1(int[][] boxes) {
		int answer = 0;
		int box_size = boxes.length;
		Map<Integer, Integer> num_boxes = new HashMap<>();
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < 2; j++) {
				if(num_boxes.get(boxes[i][j]) == null) num_boxes.put(boxes[i][j], 1);
				else num_boxes.put(boxes[i][j], num_boxes.get(boxes[i][j])+1);
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(o2-o1));
		for (int num_box : num_boxes.values()) 
			pq.offer(num_box);
		while(box_size-- > 0) {
			int cur = pq.poll();
			if(cur==1) answer++;
			else if(cur==2) continue;
			else pq.offer(cur-2);
		}
		return answer;
	}
}

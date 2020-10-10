package line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class Main_2020 {
	public static void main(String[] args) {
		String input = "if (Count of eggs is 4.> {Buy milk.}";
		System.out.println(sol1(input));
		System.out.println(sol2("4132315142",new String[]{"3241523133","4121314445","3243523133","4433325251","2412313253"}));
		System.out.println(sol3("111011110011111011111100011111",3));
		String[][] snapshots = {
				{"ACCOUNT1", "100"},
				{"ACCOUNT2", "150"},
				{"ACCOUNT10", "150"}
		};
		String[][] transactions = {
				{"1", "SAVE", "ACCOUNT2", "100"},
				{"2", "WITHDRAW", "ACCOUNT1", "50"},
				{"1", "SAVE", "ACCOUNT2", "100"},
				{"4", "SAVE", "ACCOUNT3", "500"},
				{"3", "WITHDRAW", "ACCOUNT2", "30"}
		};
		System.out.println(sol4(snapshots, transactions));
		sol5(new String[][] {
			{"doc1", "t1", "t2", "t3"},
			{"doc2", "t0", "t2", "t3"},
			{"doc3", "t1", "t6", "t7"},
			{"doc4", "t1", "t2", "t4"},
			{"doc5", "t6", "t100", "t8"}
		},new String[] {"t1", "t2", "t3"});
		sol6(new String[] {"/"},
				new String[] {
						"mkdir /a",
						"mkdir /a/b",
						"mkdir /a/b/c/d",
						"cp /a/b /", 
						"rm /a/b/c"});
	}

	private static String[] sol6(String[] directory, String[] command) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < directory.length; i++) 
			list.add(directory[i]);
		for (int i = 0; i < command.length; i++) {
			String[] comm = command[i].split(" ");
			if(comm[0].equals("mkdir")) {
				list.add(comm[1]);
			}else if(comm[0].equals("cp")) {
				int size = list.size();
				for (int j = 0; j < size; j++) {
					String dir = list.get(j);
					if(dir.length() < comm[1].length()
							|| dir.indexOf(comm[1]) == -1) continue;
//					for (int k = 0; k < comm[1].length(); k++) {
//						if(dir.charAt(k) != comm[1].charAt(k)) {
//							continue outer;
//						}
//					}
					int idx = 0;
					for (idx = comm[1].length()-1; idx >= 0; idx--) {
						if(dir.charAt(idx) == '/') break;
					}
					if(comm[2].charAt(comm[2].length()-1) == '/')
						list.add(comm[2]+dir.substring(idx+1));
					else 
						list.add(comm[2]+dir.substring(idx));
				}
			}else {
				for (int j = 0; j < list.size(); j++) {
					String dir = list.get(j);
					if(dir.length() < comm[1].length()
							|| dir.indexOf(comm[1]) < 0) continue;
//					for (int k = 0; k < comm[1].length(); k++) {
//						if(dir.charAt(k) != comm[1].charAt(k)) {
//							continue outer;
//						}	
//					}
					list.remove(dir);
					j--;
				}
			}
		}
		Collections.sort(list);
		String[] ans = new String[list.size()];
		for (int i = 0; i < list.size(); i++) 
			ans[i] = list.get(i);
		System.out.println(Arrays.toString(ans));
		return ans;
	}

	private static String[] sol5(String[][] dataSource, String[] tags) {
		Map<String, String> tagMap = new HashMap<>();
		Map<String, Integer> docsMap = new HashMap<>();
		for (int i = 0; i < dataSource.length; i++) {
			String[] ds = dataSource[i];
			for (int j = 1; j < ds.length; j++) {
				if(tagMap.get(ds[j]) != null)
					tagMap.put(ds[j], tagMap.get(ds[j]) + ds[0] + ",");
				else tagMap.put(ds[j], ds[0] + ",");
			}
		}
		for (int i = 0; i < tags.length; i++) {
			String tag = tags[i];
			String[] docs = tagMap.get(tag).split(",");
			for (int j = 0; j < docs.length; j++) {
				if(docsMap.get(docs[j]) != null)
					docsMap.put(docs[j], docsMap.get(docs[j]) + 1);
				else
					docsMap.put(docs[j], 1);
			}
		}
		List<String> list = new ArrayList<>();
		list.addAll(docsMap.keySet());
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return docsMap.get(o2)-docsMap.get(o1)==0?
					o1.compareTo(o2):docsMap.get(o2)-docsMap.get(o1);
			}
		});
		String[] ans = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		System.out.println(Arrays.toString(ans));
		return ans;
	}
	private static String[][] sol4(String[][] snapshots, String[][] transactions) {
		boolean[] v = new boolean[100000];
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < snapshots.length; i++)
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		
		for (int i = 0; i < transactions.length; i++) {
			String[] transaction = transactions[i];
			int cur_num = Integer.parseInt(transaction[0]);
			if(v[cur_num]) continue;
			v[cur_num] = true;
			String trans = transaction[1];
			String acc = transaction[2];
			if(map.get(acc)==null) {
				map.put(acc, Integer.parseInt(transaction[3]));
			}else {
				if(trans.equals("SAVE")) 
					map.put(acc, map.get(acc) + Integer.parseInt(transaction[3]));
				else 
					map.put(acc, map.get(acc) - Integer.parseInt(transaction[3]));
			}
		}
		String[][] ans = new String[map.size()][2];
		int idx = 0;
		for (String key : map.keySet()) {
			ans[idx][0] = key;
			ans[idx][1] = String.valueOf(map.get(key));
			idx++;
		}
		return ans;
		
	}

	private static int sol3(String road, int n) {
		int ans = -1;
	      int l = 0, r = 0, len = 0;
	      Queue<Integer> q = new LinkedList<>();
	      
	      while (true) {
	         if (r == road.length()) break;
	         
	         else if (road.charAt(r) == '1') {
	            len++;
	            r++;
	         } else {
	            q.offer(r);
	            len++;
	            r++;
	            if (q.size() > n) {
	               l = q.poll() + 1;
	               len = r - l;
	            }
	         }
	         if (ans < len) ans = len;
	      }
	      return ans;
	}

	private static int sol2(String answer_sheet, String[] sheets) {
		int sheet_len = sheets.length;
		int possible = 0;
		for (int i = 0; i < sheet_len; i++) {
			String sheet1 = sheets[i];
			for (int j = i+1; j < sheet_len; j++) {
				String sheet2 = sheets[j];
				int same = 0;
				int maxlen = 0,len = 0;
				for (int k = 0; k < answer_sheet.length(); k++) {
					char ch = answer_sheet.charAt(k);
					char ans1 = sheet1.charAt(k), ans2 = sheet2.charAt(k); 
					if(ans1 == ch || ans2 == ch) { 
						len = 0;
						continue;
					}
					if(ans1 == ans2) {
						same++;
						len++;
					}else {
						maxlen = Math.max(len, maxlen);
						len = 0;
					}
				}
				maxlen = Math.max(len, maxlen);
				possible = Math.max(possible, same + maxlen*maxlen);
			}
		}
		return possible;
	}

	private static int sol1(String inputString) {
		int ans = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			switch (ch) {
			case '(': 
				stack.push(ch);
				ans++;
				break;
			case '{':
				stack.push(ch);
				ans++;
				break;
			case '[':
				stack.push(ch);
				ans++;
				break;
			case '<':
				stack.push(ch);
				ans++;
				break;
			case ')':
				if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
				else return -1;
				break;
			case '}':
				if(!stack.isEmpty() && stack.peek()=='{') stack.pop();
				else return -1;
				break;
			case ']':
				if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
				else return -1;
				break;
			case '>':
				if(!stack.isEmpty() && stack.peek()=='<') stack.pop();
				else return -1;
				break;
			default:
				break;
			}
		}
		if(stack.isEmpty()) return ans;
		else return -1;
	}
}

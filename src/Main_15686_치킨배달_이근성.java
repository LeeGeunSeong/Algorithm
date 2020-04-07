import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_이근성 {
	static int N, M, ans;
	static class chick{
		int x,y;
		public chick(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static List<chick> clist;
	static List<chick> plist;
	static List<chick> tmp;
	static int[] arr;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		clist = new ArrayList<>();
		plist = new ArrayList<>();
		tmp = new ArrayList<>();
		count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 2) 
					clist.add(new chick(i, j));
				else if(temp == 1)
					plist.add(new chick(i,j));
			}
		} // end input
		arr = new int[clist.size()];
		ans = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(ans);
	}// end main
	private static void dfs(int cnt,int idx) {
		if(idx == M && isFull()) {
			tmp.clear();
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == 0) continue;
				tmp.add(clist.get(j));
			}
			int ret = calc();
			ans = Math.min(ans, ret);
			return;
		}
		if(cnt == clist.size()) return;
		arr[cnt] = 1;
		dfs(cnt+1,idx+1);
		arr[cnt] = 0;
		dfs(cnt+1,idx);
	}
	private static boolean isFull() {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) cnt++;
		}
		return cnt ==M?true:false;
	}
	private static int calc() {
		int ret = 0;
		for (int i = 0; i < plist.size(); i++) {
			chick c = plist.get(i);
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < tmp.size(); j++) {
				chick tmpC = tmp.get(j);
				int dist = dist(c,tmpC);
				if(min > dist) 
					min = dist;
			}
			ret += min;
		}
		return ret;
	}
	private static int dist(chick c, chick tmpC) {
		return Math.abs(c.x-tmpC.x) + Math.abs(c.y-tmpC.y);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2628_종이자르기_이근성 {
	static class Node{
		int x,y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N,W,H;
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken()); // 가로
		H = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(br.readLine()); // 컷 횟수
		
		list = new ArrayList<>();
		List<Integer> w = new ArrayList<>();
		List<Integer> h = new ArrayList<>();
		w.add(0);
		h.add(0);
		w.add(W);
		h.add(H);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); // 0이면 가로, 1이면 세로
			int x = Integer.parseInt(st.nextToken()); // 자르는 위치
			if(dir == 0) h.add(x);
			else w.add(x);
		}
		Collections.sort(w);
		Collections.sort(h);
		
		int ans = calcArea(w,h);
		
		System.out.println(ans);
	}// end main
	private static int calcArea(List<Integer> w2, List<Integer> h2) {
		int maxw = w2.get(1)-w2.get(0);
		int maxh = h2.get(1)-h2.get(0);
		for (int i = 1; i < w2.size()-1; i++) {
			if(w2.get(i+1) - w2.get(i) > maxw) maxw = w2.get(i+1) - w2.get(i);
		}
		for (int i = 1; i < h2.size()-1; i++) {
			if(h2.get(i+1) - h2.get(i) > maxh) maxh = h2.get(i+1) - h2.get(i);
		}
		return maxh * maxw; // 두 변 사이의 거리가 가장 먼 가로와 세로를 곱해준다.
	}

	
}

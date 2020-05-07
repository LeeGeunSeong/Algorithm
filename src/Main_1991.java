import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1991 {
	static HashMap<Character, List<Character>> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char p = st.nextToken().charAt(0);
			List<Character> list = new ArrayList<Character>();
			list.add(st.nextToken().charAt(0));
			list.add(st.nextToken().charAt(0));
			map.put(p, list);
		}
		preorder('A');
		System.out.println();
		inorder('A');
		System.out.println();
		postorder('A');
	}
	private static void postorder(char v) {
		if(v == '.') return;
		
		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		System.out.print(v);
	}
	private static void inorder(char v) {
		if(v == '.') return;
		
		inorder(map.get(v).get(0));
		System.out.print(v);		
		inorder(map.get(v).get(1));
	}
	private static void preorder(char v) {
		if(v == '.') return;
		
		System.out.print(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}
}

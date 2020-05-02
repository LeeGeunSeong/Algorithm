import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11725 {
	static class Node{
		Node parent;
		int data;
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Node[] list = new Node[N+1];
		for (int i = 0; i <= N; i++) 
			list[i] = new Node(i);
		list[1].parent = list[0];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(list[e].parent == null) list[e].parent = list[s];
			else list[s].parent = list[e];
		}
		
		for (int i = 2; i <= N; i++) {
			if(list[i].parent == null) sb.append(1 + "\n");
			sb.append(list[i].parent.data + "\n");
		}
		
		System.out.println(sb.toString());
	}
}

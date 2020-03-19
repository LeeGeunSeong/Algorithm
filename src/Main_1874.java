import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int num = 0,idx = 0;
		Stack<Integer> stack = new Stack<>();
		while(idx < N) {
			int cnt = 0;
			if(arr[idx] > num) {
				stack.push(++num);
				sb.append("+\n");
				cnt++;
			}else if(arr[idx] == stack.peek()){
				stack.pop();
				idx++;
				sb.append("-\n");
				cnt++;
			}
			if(cnt == 0) {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}

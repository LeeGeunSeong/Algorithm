import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기_이근성 {
	static int N,size,resMax,resMin;
	static int[] num,op,arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		op = new int[4];
		arr = new int[N-1];
		for (int i = 0; i < N; i++) 
			num[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			// 1 : 덧셈, 2: 뺄셈, 3: 곱셈, 4: 나눗셈
			op[i] = Integer.parseInt(st.nextToken());
			size += op[i];
		}
		resMax = Integer.MIN_VALUE; resMin = Integer.MAX_VALUE;
		
		dfs(0);
		System.out.println(resMax);
		System.out.println(resMin);
	}
	private static void dfs(int cnt) {
		if(cnt == size) {
			int res = num[0];
			for (int i = 0; i < N-1; i++) {
				switch (arr[i]) {
				case 0: res += num[i+1];
					break;
				case 1:	res -= num[i+1];
					break;
				case 2:	res *= num[i+1];
					break;
				case 3:	res /= num[i+1];
					break;
				}
			}
			resMax = Math.max(resMax, res);
			resMin= Math.min(resMin, res);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(op[i] == 0) continue;
			arr[cnt] = i;
			op[i]--;
			dfs(cnt+1);
			op[i]++;
		}
	}
}

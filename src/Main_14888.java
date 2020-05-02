import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 {
	static int N, max, min;
	static int[] op, num, pos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		op = new int[4];
		num = new int[N];
		pos = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			num[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) 
			op[i] = Integer.parseInt(st.nextToken()); // 0: +, 1: -, 2: *, 3: /
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		solve(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void solve(int cnt) {
		if(cnt==N-1) {
			int ans = calc();
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(op[i] == 0) continue;
			pos[cnt] = i;
			op[i]--;
			solve(cnt+1);
			pos[cnt] = 0;
			op[i]++;
		}
	}

	private static int calc() {
		int ret = num[0];
		for (int i = 0; i < N-1; i++) {
			switch (pos[i]) {
			case 0:
				ret += num[i+1];
				break;
			case 1:
				ret -= num[i+1];
				break;
			case 2:
				ret *= num[i+1];
				break;
			case 3:
				ret /= num[i+1];
				break;
			default:
				break;
			}
		}
		return ret;
	}
}

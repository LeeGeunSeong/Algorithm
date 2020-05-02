import java.util.Scanner;

public class Main_17471_게리맨더링_이근성_Floyd {
	static int N,ans=Integer.MAX_VALUE, INF = 10000;
	static int[] arr = {0,0,0,0,1,1},input;
	static int[][] adj;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N+1];
		input = new int[N+1];
		adj = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			input[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			int end = sc.nextInt();
			for (int j = 0; j < end; j++) {
				adj[i][sc.nextInt()] = 1;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(adj[i][j] == 0) adj[i][j] = INF;
			}
		}
		dfs(1);
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}

	private static void dfs(int cnt) {
		if(ans == 0) return;
		if(cnt == N+1) {
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if(arr[i] ==1) count++;
			}
			if(count == N) return;
			count = 0;
			for (int i = 1; i <= N; i++) {
				if(arr[i] ==0) count++;
			}
			if(count == N) return;
			int[][] newadj = new int[N+1][N+1];
			newArr(newadj);
			if(adjCheck(newadj)) {
				int sum1 = 0,sum2 = 0;
				for (int i = 1; i <= N; i++) {
					if(arr[i] == 1) 
						sum1 += input[i];
					else 
						sum2 += input[i];
				}
				int min = Math.abs(sum1 - sum2);
				ans = Math.min(min, ans);
			}
			return;
		}
		arr[cnt] = 1;
		dfs(cnt+1);
		arr[cnt] = 0;
		dfs(cnt+1);
		
	}

	private static void newArr(int[][] newadj) {
		for (int i = 1; i <= N; i++) 
			for (int j = 1; j <= N; j++) 
				newadj[i][j] = adj[i][j];
	}

	private static boolean adjCheck(int[][] newadj) {
		System.out.print("");
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i == k) continue;
				for (int j = 1; j <= N; j++) {
					if(i == j || j == k) continue;
					if(arr[i] == 1 && arr[j] == 1 && arr[k] == 1) {
							newadj[i][j] = Math.min(newadj[i][j], newadj[i][k] + newadj[k][j]);
					}else if(arr[i] == 0 && arr[j] == 0 && arr[k] == 0) {
							newadj[i][j] = Math.min(newadj[i][j], newadj[i][k] + newadj[k][j]);
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j) continue;
				if(arr[i] == 1 && arr[j] == 1 && newadj[i][j] == INF) {
					return false;
				}
				else if(arr[i] == 0 && arr[j] == 0 && newadj[i][j] == INF) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}

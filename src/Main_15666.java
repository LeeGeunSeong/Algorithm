import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_15666 {
	public static int t[], t2[], arr[], arr2[];
	static int cnt, cnt2;

	public static void main(String[] args) throws IOException {
		int N = 0;
		int M = 0;
		
		while (cnt == cnt2) {
			cnt = cnt2 = 0;
			N = (int) (Math.random() * 8) + 1;
			M = (int) (Math.random() * N) + 1;
			int[] input = new int[N];
			t = new int[M];
			t2 = new int[M];
			Set<Integer> set = new HashSet<>();
			
			for (int i = 0; i < input.length; i++) 
				input[i] = (int)(Math.random()*10000)+1;
			
			for (int i = 0; i < N; i++) 
				set.add(input[i]);
			arr = new int[set.size()];
			int index = 0;
			for (Integer i_s : set) 
				arr[index++] = i_s;
			arr2 = new int[set.size()];
			for (int i = 0; i < arr.length; i++)
				arr2[i] = arr[i];
			Arrays.sort(arr2);
			func1(0, M);
			func2(0, M);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(cnt);
		System.out.println(Arrays.toString(arr2));
		System.out.println(cnt2);
	}

	private static void func1(int k, int M) {
		if (k == M) {
			int flag = 0;
			for (int pr = 0; pr < M; pr++) {
				for (int ree = pr + 1; ree < M; ree++) {
					if (t[pr] > t[ree]) {
						flag = 1;
						break;
					}
				}
			}
			if (flag == 0) {
				cnt++;
				for (int pr = 0; pr < M; pr++) {
//            System.out.print(t[pr]+" ");
				}
//         System.out.println("");
			}

		} else {
			for (int indx = 0; indx < arr.length; indx++) {
				t[k] = arr[indx];
				func1(k + 1, M);
			}
		}
	}

	private static void func2(int k, int M) {
		if (k == M) {
			int flag = 0;
			for (int pr = 0; pr < M; pr++) {
				for (int ree = pr + 1; ree < M; ree++) {
					if (t2[pr] > t2[ree]) {
						flag = 1;
						break;
					}
				}
			}
			if (flag == 0) {
				cnt2++;
				for (int pr = 0; pr < M; pr++) {
//	            System.out.print(t[pr]+" ");
				}
//	         System.out.println("");
			}

		} else {
			for (int indx = 0; indx < arr2.length; indx++) {
				t2[k] = arr2[indx];
				func2(k + 1, M);
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들_이근성 {
	static int N,M,L,ans;
	static int[][] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		L = Integer.parseInt(st.nextToken()); 
		int[] arr = new int[N];
		int idx = 0,cnt = 0;
		arr[idx] = 1;
		int maxReceive= 1;
		
		while(maxReceive < M) {
			if(arr[idx]%2 == 0) {
				idx = (idx+L) % N;
			}else {
				if(idx - L < 0) idx = N+idx-L;
				else idx -= L;
			}
			arr[idx]++;
			for (int i = 0; i < arr.length; i++) {
				maxReceive = Math.max(maxReceive, arr[i]);
			}
			cnt++;
		}
		System.out.println(cnt);
	}//end main
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3985_롤케이크_이근성 {
	static int L,N,ans;
	static int[][] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		int[] P = new int[N+1]; 
		int[] K = new int[N+1];
		int[] arr = new int[L+1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			P[i] = Integer.parseInt(st.nextToken());
			K[i] = Integer.parseInt(st.nextToken());
		}
		int maxPred = 0,maxReal = 0;
		int predIdx = 0,realIdx = 0;
		for (int i = 1; i <= N; i++) {
			if(maxPred < K[i]-P[i]) {
				maxPred = K[i]-P[i];
				predIdx = i;
			}
			for (int j = P[i]; j <=	K[i]; j++) 
				if(arr[j] == 0) arr[j] = i;
		}
		int[] real = new int[N+1];
		for (int i = 1; i <= L; i++) 
			if(arr[i] != 0) 
				real[arr[i]]++;
		for (int i = 1; i <= N; i++) {
			if(maxReal < real[i]) {
				maxReal = real[i];
				realIdx = i;
			}
		}
		System.out.println(predIdx);
		System.out.println(realIdx);
	}//end main
}
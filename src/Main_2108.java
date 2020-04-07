import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_2108 {
	static int N;
	static int[] arr,count;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int len = 8001;
		count = new int[len];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			count[arr[i] + 4000]++;
			sum += arr[i];
		}
		Arrays.sort(arr);
		// 산술평균
		bw.write((int)Math.round((double)sum/N) + "\n");
		// 중앙값
		bw.write(arr[N/2] + "\n");	
		List<Integer> list = new ArrayList<>();
		int max = -4001,maxidx=0;
		for (int i = 0; i < len; i++) {
				if(max < count[i]) {
					maxidx = i;
					max = count[i];
					list.clear();
				}else if(count[i] != 0 && count[maxidx] == count[i]) {
					list.add(i-4000);
				}
		}
		bw.write((list.size()==0?maxidx-4000:list.get(0)) + "\n");
		// 최빈값
		bw.write((arr[N-1]-arr[0]) + "\n");
		bw.flush();
	}
}
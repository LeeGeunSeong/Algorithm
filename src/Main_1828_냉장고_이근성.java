import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1828_냉장고_이근성 {
	static int N,ans;
	static int[][] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine()); //도시
			int[][] arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); // 최저 온도
				arr[i][1] = Integer.parseInt(st.nextToken()); // 최고 온도
			}
			Arrays.sort(arr,new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[1],o2[1]);
				}
			});
			List<int[]> list = new ArrayList<int[]>();
			list.add(arr[0]);
			A:
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < list.size(); j++) 
					if(list.get(j)[1] >= arr[i][0]) continue A;
				list.add(arr[i]);
			}
			System.out.println(list.size());
	}//end main
}
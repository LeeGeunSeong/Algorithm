import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			char[] func = br.readLine().toCharArray();
			
			int N = Integer.parseInt(br.readLine());
			String[] arrStr = br.readLine().replace("[", "").replace("]", "").split(",");
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) 
				arr[i] = Integer.parseInt(arrStr[i]);
			int numR = 0, numD = 0;
			for (int i = 0; i < func.length; i++) {
				if(func[i] == 'R') numR++;
				else numD++;
			}
			if(numD > arr.length) sb.append("error\n");
			else {
				int lidx = 0,ridx = N-1;
				int idx = 0;
				boolean flag = true;
				for (int i = 0; i < func.length; i++) {
					if(func[i] == 'R') {
						 if(flag) {
							flag = false;
							idx = ridx;
						 }else {
							flag = true;
							idx = lidx;
						 }
					}else {
						if(flag) {
							lidx++;
						}else {
							ridx--;
						}
					}
				}
				sb.append("[");
				if(flag) {
					for (int i = lidx; i <= ridx; i++) {
						sb.append(arr[i]);
						if(i < ridx) sb.append(",");
					} 
				}else {
					for (int i = ridx; i >= lidx; i--) {
						sb.append(arr[i]);
						if(i > lidx) sb.append(",");
					} 
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb.toString());
	}
}

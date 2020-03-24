import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 메모리 크기
			int c = Integer.parseInt(st.nextToken()); // 코드 크기
			int i = Integer.parseInt(st.nextToken()); // 입력 크기
			
			int[] arr = new int[m];
			char[] code = br.readLine().toCharArray();
			char[] input = br.readLine().toCharArray();
			int pointer = 0, count = 0;
			boolean f = false;
			int b = 0, e = 0;
			int icnt = 0;
			for (int j = 0; j < c; j++) {
				if(++count > 50000000) {
					f = true;
					break;
				}
				switch (code[j]) {
				case '-': arr[pointer] = arr[pointer]==0?255:arr[pointer]-1;
					break;
				case '+': arr[pointer] = arr[pointer]==255?0:arr[pointer]+1;
					break;
				case '<': pointer = pointer==0?m-1:pointer-1;
					break;
				case '>': pointer = pointer==m-1?0:pointer+1;
					break;
				case '[': 
					if(arr[pointer]==0) {
						int cnt = 0, idx = j;
						for (int k = idx+1; k < c; k++) {
							if(code[k] == '[') cnt++;
							if(code[k] == ']') {
								if(cnt>0) cnt--;
								else {
									b = j;
									e = k;
									j = k-1;
									break;
								}
							}
						}
					}
					break;
				case ']':
					if(arr[pointer]>0) {
						int cnt = 0, idx = j;
						for (int k = idx-1; k >= 0; k--) {
							if(code[k] == ']') cnt++;
							if(code[k] == '[') {
								if(cnt>0) cnt--;
								else {
									b = k;
									e = j;
									j = k-1;
									break;
								}
							}
						}
					}
					break;
				case '.': 
					break;
				case ',':
					if(icnt >= i) arr[pointer] = 255;
					else arr[pointer] = input[icnt++];
					break;
				default:
					break;
				}
			}
			if(f) System.out.println("Loops "+ b + " " + e);
			else System.out.println("Terminates");
		}
	}
}

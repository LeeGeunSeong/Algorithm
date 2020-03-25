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
			int ptr = 0, count = 0;
			boolean f = false;
			int b = -1, e = -1;
			int icnt = 0;
			for (int j = 0; j < c; j++) {
				if(++count > 50000000) {
					f = true;
					int cnt = 0, idx = e;
					for (int k = idx-1; k >= 0; k--) {
						if(code[k] == ']') cnt++;
						if(code[k] == '[') {
							if(cnt>0) cnt--;
							else {
								b = k;
								break;
							}
						}
					}
					break;
				}
				switch (code[j]) {
				case '-': arr[ptr] = arr[ptr]==0?255:arr[ptr]-1;
					break;
				case '+': arr[ptr] = arr[ptr]==255?0:arr[ptr]+1;
					break;
				case '<': ptr = ptr==0?m-1:ptr-1;
					break;
				case '>': ptr = ptr==m-1?0:ptr+1;
					break;
				case '[': 
					if(arr[ptr]==0) {
						int cnt = 0, idx = j;
						for (int k = idx+1; k < c; k++) {
							if(code[k] == '[') cnt++;
							if(code[k] == ']') {
								if(cnt>0) cnt--;
								else {
									j = k-1;
									break;
								}
							}
						}
					}
					break;
				case ']':
					if(arr[ptr]>0) {
						int cnt = 0, idx = j;
						if(e < j) e = j;
						for (int k = idx-1; k >= 0; k--) {
							if(code[k] == ']') cnt++;
							if(code[k] == '[') {
								if(cnt>0) cnt--;
								else {
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
					if(icnt >= i) arr[ptr] = 255;
					else arr[ptr] = input[icnt++];
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

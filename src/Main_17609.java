import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			char[] input = br.readLine().toCharArray();
			int ans = 0, N = input.length;
			int l = 0, r = N-1;
			while(l < r) {
				if(input[l] == input[r]){
					l++; r--;
				}else if(input[l+1] == input[r] || input[l] == input[r-1]) {
					if(input[l+1] == input[r]) {
						ans = 1;
						int tl = l+1, tr = r;
						while(tl < tr) {
							if(input[tl] == input[tr]) {
								tl++; tr--;
							}else{
								ans = 2;
								break;
							}
						}
					}
					if(ans != 1 && input[l] == input[r-1]) {
						ans = 1;
						int tl = l, tr = r-1;
						while(tl < tr) {
							if(input[tl] == input[tr]) {
								tl++; tr--;
							}else {
								ans = 2;
								break;
							}
						}
					}
					break;
				}else {
					ans = 2;
					break;
				}
			}
			System.out.println(ans==0?0:ans==1?1:2); // 회문 0, 유사 1, 그외2
		}
	}
}

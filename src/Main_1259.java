import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			char[] pelindrome = str.toCharArray();
			if(pelindrome[0] == '0') break;
			boolean f = false;
			int lidx = 0, ridx = str.length()-1;
			while(lidx<=ridx) {
				if(pelindrome[lidx] == pelindrome[ridx]) {
					lidx++; ridx--;
				}else {
					f = true;
					break;
				}
			}
			if(f) System.out.println("no"); 
			else System.out.println("yes");
		}
	}
}

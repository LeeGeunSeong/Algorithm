import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("all")) {
				for (int j = 1; j <= 20; j++) 
					set.add(j);
			}else if(str.equals("empty")) {
				set.clear();
			}else {
				int num = Integer.parseInt(st.nextToken());
				if(str.equals("add")) {
					set.add(num);
				}else if(str.equals("remove")) {
					if(set.contains(num)) set.remove(num);
				}else if(str.equals("check")) {
					if(set.contains(num)) sb.append(1);
					else sb.append(0);
					sb.append("\n");
				}else {
					if(set.contains(num)) set.remove(num);
					else set.add(num);
				}
			}
		}
		System.out.println(sb.toString());
	}
}

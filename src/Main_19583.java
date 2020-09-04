import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_19583 {
	static class member{
		boolean s,e;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String S = st.nextToken(); // 시작
		String E = st.nextToken(); // 끝
		String Q = st.nextToken(); // 스트리밍 끝
		int shour = Integer.valueOf(S.split(":")[0]);
		int smin = Integer.valueOf(S.split(":")[0]);
		int ehour = Integer.valueOf(E.split(":")[0]);
		int emin = Integer.valueOf(E.split(":")[0]);
		int qhour = Integer.valueOf(Q.split(":")[0]);
		int qmin = Integer.valueOf(Q.split(":")[0]);
		Map<String, member> map = new HashMap<>();
		String input;
		while((input = br.readLine()) != null) {
			String time = input.split(" ")[0];
			String id = input.split(" ")[1];
			member m = new member();
			int hour = Integer.valueOf(time.split(":")[0]);
			int min = Integer.valueOf(time.split(":")[1]);
			if(hour <= shour) {
				if(hour == shour && min != smin) continue; 
				m.s = true;
			}
			if(hour >= ehour) {
				if(min < emin || hour > qhour || min > qmin) continue;
				m.e = true;
			}
			if(map.get(id) == null) map.put(id, m);
			else {
				member mem = map.get(id);
				mem.s |= m.s;
				mem.e |= m.e;
				map.put(id, mem);
			}
		}
		int ans = 0;
		for (member m : map.values()) 
			if(m.s && m.e) ans++;
		System.out.println(ans);
	}
}

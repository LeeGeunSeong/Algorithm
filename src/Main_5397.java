import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		while(T-- > 0) {
			String input = br.readLine();
			
//			화살표나 백스페이스까지 알아냄 -> 정확한 비밀번호
//			화살표는 <, > 위치 움직일 수 있으면 왼쪾 오른쪽으로 1씩 이동,백스페이스는 - -> 커서 앞에 글자가 있으면 지움, 
			char[] pwArray = input.toCharArray();
			StringBuilder sb = new StringBuilder();
			Deque<Character> keyLogger = new LinkedList<>();
			Deque<Character> tmpLogger = new LinkedList<>();
			for (int i = 0; i < pwArray.length; i++) {
				char ch = pwArray[i];
				
				switch (ch) {
				case '<':
					if(!keyLogger.isEmpty()) tmpLogger.addFirst(keyLogger.pollLast());
					break;
				case '>':
					if(!tmpLogger.isEmpty()) keyLogger.addLast(tmpLogger.pollFirst());
					break; 
				case '-':
					if(!keyLogger.isEmpty()) keyLogger.pollLast();
					break;

				default:
					keyLogger.add(ch);
					break;
				}
			}
			while(!keyLogger.isEmpty()) sb.append(keyLogger.pollFirst());
			while(!tmpLogger.isEmpty()) sb.append(tmpLogger.pollFirst());
			System.out.println(sb.toString());
		}
	}
}

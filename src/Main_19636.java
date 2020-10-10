import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19636 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// w0: 다이어트의 데시의 체중, l0: 에너지 섭취량 = 기초 대사량, A0: 활동 대사량 = 0kcal, t: 기초 대사량 변화 역치
		int w0 = Integer.parseInt(st.nextToken());
		int l0 = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// D: 날짜, l: 에너지 섭취량, A: 활동 대사량
		int D = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		
		int w = w0, l1 = l0;
		int change = l - l0 - A;
		boolean f1 = false, f2 = false;
		while(D-- > 0) {
			if(!f1) {
				w0 += change;
				if(w0 <= 0 || l0 <= 0) f1 = true;
			}
			if(!f2) {
				int tmpChn = l - l1 - A;
				w += tmpChn;
				if(Math.abs(tmpChn) > t) l1 += Math.floor((double)tmpChn/2);
				if(w <= 0 || l1 <= 0) f2 = true;
			}
		}
//		체중 += (에너지 섭취량 - 에너지 소비량) g/Kcal
//		에너지 소비량 = 기초 대사량 + 활동 대사량
//		(에너지 섭취량 - 에너지 소비량)의 절대값이 T를 초과하면 기초대사량은 (에너지 섭취량 - 에너지 소비량)/2의 내림 만큼 더해진다.
//		기초 대사량 변화는 체중 변화 다음에 일어난다
//		아래에 해당하면 데시는 사망한다
//		체중이 0 이하거나 기초대사량이 0 이하인 경우( Danger Diet 출력 )
//		D일간의 다이어트가 끝난 후 기초대사량의 변화를 고려했을 때 각각의 예상 체중과 기초대사량을
//		다이어트 전 데시의 원래 생활로 돌아간다면 몸무게가 증가하는 요요 현상이 일어날지 계산해주자
		if(f1) System.out.println("Danger Diet");
		else System.out.println(w0 + " " + l0);
		if(f2) System.out.println("Danger Diet");
		else System.out.println(w + " " + l1 + (l0>l1?" YOYO":" NO"));
		
	}
}

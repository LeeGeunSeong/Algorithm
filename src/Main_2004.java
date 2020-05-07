import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		long five = 0, two = 0;
		for (long i = 5; i <= N; i*= 5) five += N/i;
		for (long i = 2; i <= N; i*= 2) two += N/i;
		for (long i = 5; i <= N-M; i*= 5) five -= (N-M)/i;
		for (long i = 2; i <= N-M; i*= 2) two -= (N-M)/i;
		for (long i = 5; i <= M; i*= 5) five -= M/i;
		for (long i = 2; i <= M; i*= 2) two -= M/i;
		System.out.println(five<two?five:two);
	}
}

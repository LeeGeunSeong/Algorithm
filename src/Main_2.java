import java.io.IOException;

public class Main_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//      System.setIn(new FileInputStream("test2.txt"));
		int N = 100000;
		int K = 10;
		String input_v = "";
		for (int i = 0; i < N; i++) {
			input_v += (int)(Math.random()*10);
		}
		long max_v = 0;
		if (N == K) {
			System.out.println(Long.parseLong(input_v));
		} else {
			for (int i = 0; i < (N - K + 1); i++) {
				String tmp = input_v.substring(i, i + K);
				long value = Long.parseLong(tmp);
				if (value > max_v) {
					max_v = value;
				}
			}
			System.out.println(max_v);
		}
		System.exit(0);
	}

}
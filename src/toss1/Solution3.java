//package toss1;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class Solution3 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String input = br.readLine();
//		int N = input.split(" ").length;
//		StringTokenizer st = new StringTokenizer(input);
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for (int i = 0; i < N; i++) {
//			int tmp = Integer.parseInt(st.nextToken());
//			if(map.get(tmp) == null) {
//				int output = Function.compute(tmp);
//				map.put(tmp, output);
//				System.out.print(output + " ");
//			}else {
//				System.out.print(map.get(tmp) + " ");
//			}
//		}
//	}
//}

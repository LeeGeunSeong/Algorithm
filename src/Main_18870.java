import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] pos = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		int val = 0;
		for (int i = 0; i < N; i++) 
			pos[i] = Integer.parseInt(st.nextToken());
		
		int[] tmp = pos.clone();
		Arrays.sort(tmp);
		for (int i = 0; i < pos.length; i++) 
			if(map.get(tmp[i]) == null)
				map.put(tmp[i],val++);
			
		for (int i = 0; i < N; i++)
			pos[i] = map.get(pos[i]);
		
		for (int i = 0; i < N; i++)
			sb.append(pos[i] + " ");
		
		System.out.println(sb.toString());
	}
}

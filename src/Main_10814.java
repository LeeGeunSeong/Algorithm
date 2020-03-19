import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10814 {
	static class user{
		int age,order;
		String name;
		
		public user(int age, String name,int order) {
			super();
			this.age = age;
			this.name = name;
			this.order = order;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		
		List<user> list = new ArrayList<>();
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new user(Integer.parseInt(st.nextToken()),st.nextToken(),i));
		}
		Collections.sort(list, new Comparator<user>() {

			@Override
			public int compare(user o1, user o2) {
				return o1.age-o2.age==0?o1.order-o2.order:o1.age-o2.age;
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i).age + " " + list.get(i).name);
		}
	}
}

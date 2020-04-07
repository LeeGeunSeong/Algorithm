public class Main_4673_셀프넘버_이근성 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		boolean[] flag = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
			int tmp = i;
			int x = tmp;
			int sum = 0;
			while(x > 0) {
				sum += x % 10;
				x /= 10;
			}
			if(tmp+sum > 10000) continue;
			flag[tmp+sum] = true;
		}
		for (int i = 1; i <= 10000; i++) 
			if(!flag[i])  sb.append(i).append("\n");
		
		System.out.println(sb);
	}
	
}

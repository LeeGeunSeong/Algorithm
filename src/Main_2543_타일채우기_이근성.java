import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2543_타일채우기_이근성 {
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		div(0,0,N-1,N-1,x,y);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void div(int imin, int jmin, int imax, 
								int jmax, int x, int y) {
		if(imin == imax) return;
		int imid = (imin+imax)/2, jmid = (jmin+jmax)/2;
		
		if(x >= imin && y >= jmin && x <= imid && y <= jmid) { // 1
			map[imid+1][jmid] = map[imid][jmid+1] = map[imid+1][jmid+1] = 1;
			
			div(imin, jmin, imid, jmid, x, y); 
			div(imid+1, jmin, imax, jmid, imid+1, jmid); 
			div(imin, jmid+1, imid, jmax, imid, jmid+1); 
			div(imid+1, jmid+1, imax, jmax, imid+1, jmid+1); 
			
		}else if(x >= imin && y > jmid && x <= imid && y <= jmax) { //2
			map[imid][jmid] = map[imid+1][jmid] = map[imid+1][jmid+1] = 2;
			
			div(imin, jmin, imid, jmid, imid, jmid);
			div(imin, jmid+1, imid, jmax, x, y);
			div(imid+1, jmin, imax, jmid, imid+1, jmid);
			div(imid+1, jmid+1, imax, jmax, imid+1, jmid+1);
			
		}else if(x > imid && y >= jmin && x <= imax && y <= jmid) { // 3
			map[imid][jmid] = map[imid][jmid+1] = map[imid+1][jmid+1] = 3;
			
			div(imin, jmin, imid, jmid, imid, jmid);
			div(imin, jmid+1, imid, jmax, imid, jmid+1);
			div(imid+1, jmin, imax, jmid, x, y);
			div(imid+1, jmid+1, imax, jmax, imid+1, jmid+1);
			
		}else if(x > imid && y > jmid && x <= imax && y <= jmax) { // 4
			map[imid][jmid] = map[imid][jmid+1] = map[imid+1][jmid] = 4;
			
			div(imin, jmin, imid, jmid, imid, jmid);
			div(imid+1, jmin, imax, jmid, imid+1, jmid);
			div(imin, jmid+1, imid, jmax, imid, jmid+1);
			div(imid+1, jmid+1, imax, jmax, x, y);
		}
	}
}

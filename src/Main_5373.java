//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main_5373 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int tc = Integer.parseInt(br.readLine());
//		char[][][] arr = new char[6][3][3]; 
//		// 0 : 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				arr[0][i][j] = 'w';
//				arr[1][i][j] = 'y';
//				arr[2][i][j] = 'r';
//				arr[3][i][j] = 'o';
//				arr[4][i][j] = 'g';
//				arr[5][i][j] = 'b';
//			}
//		}
//		for (int i = 0; i < tc; i++) {
//			int N = Integer.parseInt(br.readLine()); 
//			
//			String[] tmp = br.readLine().split(" ");
//			for (int j = 0; j < N; j++) {
//				String str = tmp[0];
//				
//				char plane = str.charAt(0);
//				char dir = str.charAt(1);
//				int[] num = new int[4];
//				if(dir == '-') {
//					switch (plane) {
//					case 'U':
//						num[0] = 5;
//						num[1] = 2;
//						num[2] = 4;
//						num[3] = 3;
//						break;
//					case 'D':
//						num[0] = 5;
//						num[1] = 3;
//						num[2] = 4;
//						num[3] = 2;
//						break;
//					case 'F':
//						// 0 : 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오
//						num[0] = 5;
//						num[1] = 1;
//						num[2] = 4;
//						num[3] = 0;
//						break;
//					case 'B':
//						num[0] = ;
//						num[1] = ;
//						num[2] = ;
//						num[3] = ;
//						break;
//					case 'L':
//						num[0] = ;
//						num[1] = ;
//						num[2] = ;
//						num[3] = ;
//						break;
//					case 'R':
//						num[0] = ;
//						num[1] = ;
//						num[2] = ;
//						num[3] = ;
//						break;
//
//					default:
//						break;
//					}
//				}else {
//					
//				}
//			}
//		}
//	}
//}

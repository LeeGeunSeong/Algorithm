import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴_이근성 {
	static int[][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        map = new int[4][8];
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
        	char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                map[i][j] = tmp[j]-'0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
             
            int magnet = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            int lAdj = map[magnet][6];
            int rAdj = map[magnet][2];
            int ldir = dir,rdir = dir;
            rotate(magnet,dir);
            int cnt = magnet;
            while(cnt-- > 0) {
                if(map[cnt][2] == lAdj) break;
                ldir = ldir==-1?1:-1;
                lAdj = map[cnt][6];
                rotate(cnt,ldir);
            }
            cnt = magnet;
            while(cnt++ < 3) {
                if(map[cnt][6] == rAdj) break;
                rdir = rdir==-1?1:-1;
                rAdj = map[cnt][2];
                rotate(cnt,rdir);
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += map[i][0]*Math.pow(2, i);
        }
        System.out.println(ans);
    }
 
    private static void rotate(int i, int dir) {
        if(dir == -1) {
            int tmp = map[i][0];
            for (int j = 1; j < 8; j++) 
                map[i][j-1] =map[i][j];
            map[i][7] = tmp;
        }else {
            int tmp = map[i][7];
            for (int j = 7; j > 0; j--) 
                map[i][j] = map[i][j-1];
            map[i][0] = tmp;
        }
    }
}

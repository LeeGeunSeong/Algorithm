import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_2617_구슬찾기_이근성{
    static int[][] coin;
    static int N, middle,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        N = Integer.parseInt(st.nextToken()); // 동전 개수
        int M = Integer.parseInt(st.nextToken()); // 저울에 올려 본 쌍의 개수
         
        coin = new int[N+1][N+1];// 자신보다 작은 동전을 찾는 배열
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coin[x][y] = 1; 
        } // end input
        middle = N /2; // middle보다 무겁거나 가벼운 동전의 개수가 크게 되면 중간이 될 수 없다
        ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if(coin[i][j] == 1) 
                    findCoin(i,j);
            }
        }
        ans += calcCnt(coin);
        System.out.println(ans);
        }// end main
    private static void findCoin(int prev, int idx) {
        for (int i = 1; i <= N; i++) {
            if(coin[idx][i] == 0) continue;
            if(coin[prev][i] == 0) {
            	coin[prev][i] = 1;
            	findCoin(prev, i);
            }
        }
    }
    private static int calcCnt(int[][] arr) {
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            int lcnt = 0,hcnt = 0;
            for (int j = 1; j <= N; j++) {
                if(arr[i][j] != 0) lcnt++;
                if(arr[j][i] != 0) hcnt++;
            }
            if(lcnt > middle || hcnt > middle) ret++;
        }
        return ret;
    }
     
}
 
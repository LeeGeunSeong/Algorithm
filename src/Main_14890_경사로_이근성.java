import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
public class Main_14890_경사로_이근성 {
 
    static int N,L;
    static int[][] map;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
 
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            if(canGo(i, 0)) count++;
            if(canGo(i, 1)) count++;
        }
        System.out.println(count);
    }
 
    static boolean canGo(int idx, int d) {
        int[] h = new int[N];
        boolean[] v = new boolean[N];
 
        for(int i=0; i<N; i++) {
            if(d == 0) h[i] = map[idx][i];
            else h[i] = map[i][idx];
        }
        for(int i=0; i<N-1; i++) {
            if(h[i] == h[i+1]) continue;
            if(Math.abs(h[i] - h[i+1]) > 1) return false;
 
            if(h[i] - 1 == h[i+1]) {
                for(int j=i+1; j<=i+L; j++) {
                    if(j >= N || h[i+1] != h[j] || v[j] == true) return false;
                    v[j] = true;
                }
            }
            else if(h[i] + 1 == h[i+1]) {
                for(int j=i; j>i-L;j--) {
                    if(j < 0 || h[i] != h[j] || v[j] == true) return false;
                    v[j] = true;
                }
            }            
        }
        return true;
    }
}
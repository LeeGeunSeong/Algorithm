/**************************************************************
    Problem: 1809
    User: skscp223
    Language: Java
    Result: Success
    Time:1620 ms
    Memory:29416 kb
****************************************************************/
 
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
class Top{
    int idx;
    int height;
    public Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}
public class Main_1809_탑 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int[] arr = new int[N];
        int[] ans = new int[N];
        Stack<Top> stack = new Stack<>();
        ArrayList<Integer> arrlist = new ArrayList<>();
         
        int cnt=0;
        for (int i = 0; i < ans.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()) bw.write(0+" ");
            else {
                while(!stack.isEmpty()) {
                    if(stack.peek().height < arr[i]) {
                        stack.pop();
                        if(stack.isEmpty()) bw.write(0+" ");
                         
                    }else {
                    	String s = ""+stack.peek().idx;
                        bw.write(s+" ");
                        break;
                    }
                }
            }
            stack.push(new Top(++cnt,arr[i]));
        }
         
        bw.flush();
    }
 
}
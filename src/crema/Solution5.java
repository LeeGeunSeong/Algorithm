package crema;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result5 {

    /*
     * Complete the 'ArithmeticEquation' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER N as parameter.
     */

    public static int ArithmeticEquation(int N) {
    // Write your code here
    	boolean[] isPrime = new boolean[N+1];
    	Arrays.fill(isPrime, true);
    	
    	for (int i = 2; i <= N; i++) 
			for (int j = 2; j * i <= N; j++) 
				isPrime[i*j] = false;
    	
    	int ret = 1, mod = 1000007;
    	long tmp = 1;
    	for (int i = 2; i <= N; i++) {
    		if(!isPrime[i]) continue;
    		int n = N;
    		int exp = 0;
    		while(n > 1) {
    			n /= i;
    			exp = (exp%mod + n%mod)%mod;
    		}
    		tmp = (((exp*2+1)%mod)*(tmp%mod))%mod;
		}
    	tmp %= mod;
    	ret = (int) tmp;
    	return ret;
    }

}

public class Solution5 {
    public static void main(String[] args) throws IOException {
    	String[] arr = {"i","im","it","no","but","wont","more","wait","yours","cannot","hesiate",};
    	System.out.println(Arrays.toString(arr));
    	 for (int i = 0; i < arr.length - 1; i++) {
             if (arr[i].length() == arr[i + 1].length()) {
                for (int j = 0; j < arr[i].length(); j++) {
                   if (arr[i].charAt(j) < arr[i + 1].charAt(j)) {
                      String temp = arr[i];
                      arr[i] = arr[i + 1];
                      arr[i + 1] = temp;
                      break;
                   }
                }
             }
    	 }
//    	 for (int i = 0; i < arr.length; i++) {
// 			for (int j = 0; j < i; j++) {
// 				if((arr[i].length()-arr[j].length()==0 &&
// 						arr[i].compareTo(arr[j]) < 0) || 
// 						arr[i].length() < arr[j].length()) {
// 					String tmp = arr[i];
// 					arr[i] = arr[j];
// 					arr[j] = tmp;
// 				}
// 			}
// 		}
    	for (int i = 0; i < arr.length-1; i++) {
			if(arr[i].length()-arr[i+1].length()==0) {
				for (int k = 0; k < arr[i].length(); k++) {
					if(arr[i].charAt(k) < arr[i+1].charAt(k)) {
						String tmp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = tmp;
						break;
					}else if(arr[i].charAt(k) > arr[i+1].charAt(k)) break;
				}
			}else if(arr[i].length() < arr[i+1].length()) {
				String tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
			}
		}
    	System.out.println(Arrays.toString(arr));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result5.ArithmeticEquation(N);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

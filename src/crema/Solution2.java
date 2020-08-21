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



class Result2 {

    /*
     * Complete the 'getMostVisited' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY sprints
     */

    public static int getMostVisited(int n, List<Integer> sprints) {
    // Write your code here
        int[] count = new int[n+1];
        int cur = sprints.get(0)-1;
        int len = sprints.size();
        for(int i = 1; i < len; i++){
            int next = sprints.get(1)-1;
            int s = Math.min(cur,next);
            int e = Math.max(cur,next);
            count[s]++;
            count[e+1]--;
            cur = next;
        }
        int[] scores = new int[n];
        scores[0] = count[0];
        for(int i = 1; i < n; i++)
            scores[i] = scores[i-1] + count[i];
        int max = 0, maxidx = 0;
        for (int i = 0; i < n; i++) {
        	if(scores[i] > max) {
        		max = scores[i];
        		maxidx = i;
        	}
		}
        return maxidx+1;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int sprintsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sprints = IntStream.range(0, sprintsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result2.getMostVisited(n, sprints);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

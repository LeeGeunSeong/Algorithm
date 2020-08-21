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



class Result4 {

    /*
     * Complete the 'droppedRequests' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY requestTime as parameter.
     */

    public static int droppedRequests(List<Integer> requestTime) {
    // Write your code here
        int cur = requestTime.get(0), next = 0, sec = 1, ten = 0, min = 0;
        int ret = 0, len = requestTime.size(), first = cur;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 1; i < len; i++) {
            next = requestTime.get(i);
            if(next > cur) {
                countMap.put(cur, sec);
                cur = next;
                sec = 1;
            }else sec++;
        }
        countMap.put(next, sec);
        
        for (int i = first; i <= next; i++) {
            sec = countMap.getOrDefault(i, 0);
            if(i >= 10) ten -= countMap.getOrDefault(i-10, 0);
            if(i >= 60) min -= countMap.getOrDefault(i-60, 0);
            if(sec == 0) continue;
            int possible = Math.min(Math.min(3, sec)
                    , Math.min(20-ten, 60-min));
            if(possible < 0) possible = 0;
            ten += sec;
            min += sec;
            ret += sec-possible;
        }
        return ret;
    }
}

public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> requestTime = IntStream.range(0, requestTimeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result4.droppedRequests(requestTime);
        System.out.println(result);

        bufferedReader.close();
    }
}

package crema;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;



class Result {

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
        int cur = sprints.get(0)-1, len = sprints.size();
    	int[] visited = new int[n];
    	for(int i = 1; i < len; i++){
    		int next = sprints.get(i)-1;
    		if(next > cur){
    			for(int j = cur; j <= next; j++) visited[j]++;
    		}else{
    			for(int j = next; j <= cur; j++) visited[j]++;
    		}
    		cur = next;
    	}
    	int max = 0, maxidx = 0;
    	for(int i = 0; i < n; i++){
    		if(max < visited[i]){
    			maxidx = i;
    			max = visited[i];
    		}
    	}
    	return maxidx+1;
    }

}

public class Solution {
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

        int result = Result.getMostVisited(n, sprints);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

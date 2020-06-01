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



class Result3 {

    /*
     * Complete the 'longestChain' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY words as parameter.
     */
	static Map<String, Integer> map = new HashMap<>();
	public static int dfs(String word) {
		if(word.length()==0) return 0;
		
		if(map.get(word) != null) {
			int max = 0;
			for (int i = 0; i < word.length(); i++) {
				String newWord = word.substring(0, i) + word.substring(i+1,word.length());
				if(map.get(newWord) > 0)
					max = Math.max(max, map.get(newWord)+1);
				else
					max = Math.max(max, dfs(newWord)+1);
			}
			map.put(word, max);
			return map.get(word);
		}
		else return 0;
	}
    public static int longestChain(List<String> words) {
    // Write your code here
        int max = 0;
        int len = words.size();
        for (int i = 0; i < words.size(); i++) 
			map.put(words.get(i), 0);
		
        for(int i = 0; i < len; i++){
            String word = words.get(i);
            int chain = 1;
            max = Math.max(max, dfs(word));
        }
        return max;
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, wordsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result3.longestChain(words);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

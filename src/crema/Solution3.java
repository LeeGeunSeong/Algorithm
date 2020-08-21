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

    public static int longestChain(List<String> words) {
    // Write your code here
    	int len = words.size();
    	int max = 0;
    	Collections.sort(words, (a,b) -> a.length()-b.length());
    	Map<String, Integer> countMap = new HashMap<>();
    	wordSet = new HashSet<>(words);
    	for (int i = 0; i < len; i++) {
    		String word = words.get(i);
    		countMap.put(word, 1);
    		for (int j = 0; j < word.length(); j++) {
				StringBuilder sb = new StringBuilder(word);
				sb.delete(j, j+1);
				if(wordSet.contains(sb.toString())) {
					countMap.put(word, countMap.get(sb.toString())+1);
				}
			}
    		max = Math.max(max, countMap.get(word));
    	}
    	return max;
    }
    static Set<String> wordSet; 
	private static int checkWord(String word, List<String> words) {
		if(word.length() == 1) return 1;

		Stack<StringBuilder> stack = new Stack<>();
		int idx = 1;
		stack.add(new StringBuilder(word));
		while(!stack.isEmpty()) {
			StringBuilder curWord = stack.peek();
			if(idx > curWord.length()) break;
			
			if(words.contains(curWord.toString())) {
				StringBuilder newWord = new StringBuilder(curWord);
				newWord.delete(idx-1, idx);
				stack.add(newWord);
			}else {
				stack.pop();
				idx++;
			}
		}
		
		return stack.size();
	}

}

public class Solution3 {
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

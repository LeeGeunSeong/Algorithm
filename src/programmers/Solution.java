package programmers;

public class Solution {
	 static public int solution(String s){
	        int len = s.length();
	        char[] input = s.toCharArray();
	        for (int i = len; i > 1; i--) {
				for (int j = 0; i+j <= len; j++) {
					boolean isPalindrome = true;
					for (int k = 0; k < len/2; k++) {
						if(input[j+k] != input[i+j-k-1]) {
							isPalindrome = false;
							break;
						}
					}
					if(isPalindrome) return i;
				}
			}
	        return 1;
	}
	 public static void main(String[] args) {
		System.out.println(solution("abacde"));
	}
}

package programmers;

import java.util.Arrays;

public class main {
	public static void main(String[] args) {
//		String[] strs = {"abcaefg", "abcdefg", "abcdhfg"};
//		System.out.println(sol1(strs));
//		System.out.println(sol2());
		int[][] board = {{1,1,3,3},{4,1,3,4},{1,2,1,1},{2,1,3,2}};
		System.out.println(sol3(board));
	}

	private static String sol1(String[] strs) {
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		String f = strs[0];
		
		for (int i = 0; i < f.length(); i++) {
			char ch = f.charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if(ch == strs[j].charAt(i)) continue;
				flag = false;
				break;
			}
			if(flag) sb.append(ch);
		}
		return sb.toString();
	}

	private static int sol2(int x, int y, int r, int d, int[][] target) {
		int answer = 0;
        
        double tan = Math.toDegrees(Math.atan((double)y/x));
        if(x < 0) tan += 180;
        else if(y < 0) tan += 360;
        
        System.out.println(tan);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("Hello Java");
        for(int i = 0; i < target.length; i++){
            int[] point = target[i];
            if(Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2))> r) 
                continue;
            double tDegree = Math.toDegrees(Math.atan((double)point[1]/point[0]));
            if(point[0] < 0) tDegree += 180;
            else if(point[1] < 0) tDegree += 360;
            
            if(Math.abs(tDegree - tan) < d) answer++;
        }
        System.out.println(answer);        
        return answer;
	}

	static int max,ans;
	public static int sol3(int[][] board) {
		int answer = 0;
	
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
            	max = 1;
                int[][] tmp = copy(board);
                for(int idx = i; idx > 0; idx--)
                    tmp[idx][j] = tmp[idx-1][j];
                tmp[0][j] = 0;
                boolean[][] mask = masking(tmp);
                while(check(mask,tmp)) {
                	drop(mask,tmp);
                	mask = masking(tmp);
                }
                answer = Math.max(max, answer);
            }
        }
		return answer;
	}
	private static boolean check(boolean[][] mask, int[][] tmp) {
		for (int i = 0; i < mask.length; i++) 
			for (int j = 0; j < mask.length; j++) 
				if(mask[i][j] && tmp[i][j] > 0) return true;
		return false;
	}

	private static void drop(boolean[][] mask, int[][] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp.length; j++) {
				if(mask[i][j] && tmp[i][j] > 0) {
					tmp[i][j] = 0;
					max++;
				}
			}
		}
		for (int i = 0; i < tmp.length; i++) {
			int start = tmp.length-1;
			while(tmp[--start][i] > 0 && start > 0) ;
			int idx = start-1;
			while(idx >= 0) {
				if(tmp[idx][i] > 0) {
					if(tmp[start][i] == 0) { 
						tmp[start--][i] = tmp[idx][i];
						tmp[idx--][i] = 0;
					}else start--;
				}else idx--;
			}
		}
	}
    public static boolean[][] masking(int[][] board){
        boolean[][] ret = new boolean[board.length][board.length];
        boolean[][] wret = new boolean[board.length][board.length];
        boolean[][] hret = new boolean[board.length][board.length];
        for(int i = 0; i < board.length; i++){
            int f = board[0][i], cnt = 0, idx = 0,fidx = 0;
            hret[0][i] = true;
        	while(++idx < board.length) {
        		int tmp = board[idx][i];
        		if(f == tmp) {
        			cnt++;
        		}else {
        			f = tmp;
        			int tidx = idx;
        			if(cnt < 3) 
        				while(tidx-- > fidx) hret[tidx][i] = false;
        			
        			fidx = idx;
        			cnt = 1;
        		}
        		hret[idx][i] = true;
        	}
        	if(cnt < 3)
        		while(idx-- > fidx) hret[idx][i] = false;
        }
        for(int i = 0; i < board.length; i++){
        	int f = board[i][0], cnt = 0, idx = 0,fidx = 0;
        	wret[i][0] = true;
        	while(++idx < board.length) {
        		int tmp = board[i][idx];
        		if(f == tmp) {
        			cnt++;
        		}else {
        			f = tmp;
        			int tidx = idx;
        			if(cnt < 3) 
        				while(tidx-- > fidx) wret[i][tidx] = false;
        			
        			fidx = idx;
        			cnt = 1;
        		}
        		wret[i][idx] = true;
        	}
        	if(cnt < 3) 
        		while(idx-- > fidx) wret[i][idx] = false;
        }
        for (int i = 0; i < hret.length; i++) 
			for (int j = 0; j < hret.length; j++) 
				if(hret[i][j] || wret[i][j]) ret[i][j] = true;
        return ret;
    }
    public static int[][] copy(int[][] board){
        int[][] ret = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                ret[i][j] = board[i][j];
            }
        }
        return ret;
    }
}

package olimgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZipView {
	static int N, INF;
	static int[][] dist, customer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		INF = 100000000;
		customer = new int[N][N];
		dist = new int[N][1<<N];
		
		String[] tmp = br.readLine().split("], ");
		for (int i = 0; i < tmp.length; i++) {
			String[] dist = tmp[i].split(", ");
			for (int j = 0; j < dist.length; j++) 
				customer[i][j] = Integer.parseInt(dist[j].replaceAll("[^0-9]", ""));
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N; j++) 
				Arrays.fill(dist[j], INF);
			min = Math.min(min, TSP(i,0));
		}
		System.out.println(min);
	}
	private static int TSP(int cust, int visit) {
		if(visit == (1<<N)-1) // 전체 방문 
			return 0;
		
		if(dist[cust][visit] != INF) 
			return dist[cust][visit];
		
		for (int i = 0; i < N; i++) { 
			if((visit & 1<<i) != 0) continue; // 이미 방문
			dist[cust][visit] = Math.min(dist[cust][visit]
					, TSP(i,visit | 1<<i) + customer[cust][i]);
		}
		return dist[cust][visit];
	}
}

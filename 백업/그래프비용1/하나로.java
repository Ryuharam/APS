package 그래프비용1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하나로 {
	
	static int N;
	static int[][] land;
	static int size;
	static int[][] E;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String n = br.readLine();
			N = Integer.parseInt(n);
			
			land = new int[N][2];
			
			String X = br.readLine();
			StringTokenizer st1 = new StringTokenizer(X);
			String Y = br.readLine();
			StringTokenizer st2 = new StringTokenizer(Y);
			
			for(int i=0 ; i<N ; i++) {
				land[i][0] = Integer.parseInt(st1.nextToken());
				land[i][1] = Integer.parseInt(st2.nextToken());
			}
			
			// 간선, N개 중 2개 고르기 : 조합
			size = N*(N-1)/2;
			E = new int[size][3];
			int[] data = new int[2];
			
			comb(0);
			
			
			
			
			
			
		}
		
		
	}

	private static void comb(int idx) {
		if (idx==2) {
			
		}
		
		
	}

}

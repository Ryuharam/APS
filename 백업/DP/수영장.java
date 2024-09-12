package DP;

import java.util.Scanner;

public class 수영장 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int[] plan = new int[13];	// 1월 부터
			
			int day = sc.nextInt();		
			int month = sc.nextInt();
			int tMonth = sc.nextInt();
			int year = sc.nextInt();
			
			for(int i=1 ; i<13 ; i++) {
				plan[i] = plan[i-1] + Math.min(day*sc.nextInt(), month);
				if(i>=3) {
					plan[i] = Math.min(plan[i], plan[i-3]+tMonth);
				}
				
			}
			
			int answer = Math.min(plan[12], year);
			
			System.out.println("#"+tc+" "+answer);
			
		}
		
		
		
		
	}

}

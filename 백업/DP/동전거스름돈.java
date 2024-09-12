package DP;

import java.util.Scanner;

public class 동전거스름돈 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] moneys = new int[] {0, 50000,10000,5000,1000,500,100,50,10};
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = sc.nextInt();	// 거슬러 주어야 할 금액
			
			int[] memo = new int[9];
			
			for(int i=1 ; i<9 ; i++) {
				while(N>=moneys[i]) {
					memo[i]++;
					N -= moneys[i];
				}
			}
			
			// 출력
			System.out.println("#"+tc);
			for(int i=1 ; i<9 ; i++) {
				System.out.print(memo[i]+" ");
			}
			System.out.println();
			
		}
		
		
	}

}

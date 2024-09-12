package DP;

import java.util.Arrays;
import java.util.Scanner;

public class fibonacci3 {
	static int[] callFibo = new int[1000];
	static int[] memo;	// 계산 값을 저장하기 위한 공간을 할당
	
	static {
		memo = new int[1000];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 음수는 들어오지 않는다고 가정
		int N = sc.nextInt();
		
		System.out.println(fibo3(N));
		System.out.println(fibo2(N));
//		System.out.println(fibo1(N));
//		System.out.println(Arrays.toString(callFibo));	// 무수히 많은 중복호출이 존재
		
	}
	
	public static int fibo3(int n) {
		// 내가 처리할 값이 21억을 넘을 것 같으면 long 처리해야 한다.
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2 ; i<=n ; i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		return dp[n];
	}
	
	
	public static int fibo2(int n) {
		
//		if(n>=2 && memo[n]==0) {
		if(memo[n]==-1) {
			memo[n] = fibo2(n-1)+fibo2(n-2);
		}
		return memo[n];
	}
	
	public static int fibo1(int n) {
		callFibo[n]++;
		// 기저 조건 n==0 : 0을 반환 / n==1 : 1을 반환
		if(n<2) return n;
		return fibo1(n-1) + fibo1(n-2);
	}
	

}

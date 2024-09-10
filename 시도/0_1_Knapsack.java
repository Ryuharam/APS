package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
	
	static class Stuff implements Comparable<Stuff>{
		int idx;
		int V;
		int C;
		
		Stuff(int idx, int V, int C){
			this.idx = idx;
			this.V = V;
			this.C = C;
			stuffs[idx] = this;
		}

		@Override
		public int compareTo(Stuff o) {
			return this.V - o.V;
		}
	}
	
	static int N, K;
	static Stuff[] stuffs;
	static int[] Bag;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();	// 물건의 개수
			K = sc.nextInt();	// 가방 부피
			stuffs = new Stuff[N+1];	// 물건들의 배열
			Bag = new int[K+1];		// 가방 무게별로 최대 가치 저장
			visited = new boolean[N+1];	// 해당 물건 선택 여부
			
			for(int i=1 ; i<N+1 ; i++) {
				Stuff curr = new Stuff(i, sc.nextInt(), sc.nextInt());
			}
			stuffs[0] = new Stuff(0,0,0);	// null point 제거
			Arrays.sort(stuffs);
			
			for(int b=1 ; b<K+1 ; b++) { // 가방의 부피가 b 일 때, 최대 가치 저장
				int max = Bag[b-1];
				int maxIdx = 0;
				for(int s=1 ; s<N+1 ; s++) {	// 가방의 부피 b 보다 작은 물건들 선택
					if(stuffs[s].V > b) break;	// 물건의 최저 무게보다 가방의 부피가 작으면 
					if(stuffs[s].C + Bag[b-stuffs[s].V] > max && !visited[s]) {
						max = stuffs[s].C + Bag[b-stuffs[s].V];
						maxIdx = s;
					}
				}
				Bag[b] = max;
				visited[maxIdx] = true;
			}
			
			System.out.println("#"+tc+" "+Bag[K]);
			

		} // tc

	} // main

}

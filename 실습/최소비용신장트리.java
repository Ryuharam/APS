package 그래프비용1;

import java.util.Arrays;
import java.util.Scanner;

/* 최소 비용 신장 트리 (Minimum Spanning Tree)
 * 	- 신장 트리 : cycle이 있어서는 안된다
 * 		- 그래프의 모든 정점과 간선의 부분집합으로 구성되는 트리
 * 		- 간선의 최소 개수 : 정점의 개수 - 1
 *  - 최소 신장 트리
 *  	- 신장 트리 중에서 사용된 간선들의 가중치 합이 최소인 트리
 *  	- 무 방향 가중치 그래프
 *  	- N개의 정점을 가지는 그래프에 대해 반드시 (N-1)개의 간선을 사용
 *  	- 사이클을 포함 X
 *  - 왜 사용하는 가?
 *  	- 도로망, 통신망, 유통망 등등 여러 분야에서 비용을 최소로 해야 이익을 볼 수 있다
 *  	- 대표적인 알고리즘으로 크루스칼, 프림이 있다
 *  KRUSKAL Algorithm
 *   - 크루스칼 알고리즘
 *   	1. 최초, 모든 간선을 가중치에 따라 오름차순으로 정렬
 *   	2. 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가시킴
 *   		-> '사이클이 존재'하면 다음으로 가중치가 낮은 간선 선택
 *   	3. N-1 개의 간선이 선택될 때 까지 2.반복 
 * 
 */

public class 최소비용신장트리 {
	
	static class Edge implements Comparable<Edge>{
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
//			return Integer.compare(this.w, o.W);
		}
		
		
	}


	private static int[] p;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();	// 정점의 개수 (정점의 시작 번호를 보고)
		int E = sc.nextInt();	// 간선의 개수
		
		Edge[] edges = new Edge[E];
		
		for(int i=0 ; i<E ; i++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			edges[i] = new Edge(A,B,W);
			
		}	// 입력 끝
		
		// 크루스칼 제 1장 : 가중치 순으로 정렬을 해라!
		
		Arrays.sort(edges);
		
		// 크루스칼 제 2장 : V-1 개의 간선을 뽑아라! (사이클이 발생하지 않게)
		// 상호배타집합 (서로소집합, 유니온 파인드)
		
		p = new int[V];	// 0번부터 시작해서
		
		// make-set을 통해 전체 자신을 대표로 만드는 작업을 수행한다.
		for(int i=0 ; i<V ; i++) {
//			makeSet(i);
			p[i] = i;
		}
		
		int ans = 0;	// 최소 비용을 저장하기 위한 변수
		int pick = 0;	// 내가 뽑은 간선의 개수
		
		for(int i=0 ; i<E ; i++) {
			
//			int x = edges[i].A;
//			int y = edges[i].B;
//			
//			// 사이클이 발생하는지 검사를 해야한다
//			
//			if(findSet(x) != findSet(y)) {
//				union(x,y);
//				ans += edges[i].W;
//				pick++;
//			}
			
			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);
			
			if(px!=py) {
				union(px, py);
				ans += edges[i].W;
				pick++;
			}
			
			
			if(pick==(V-1)) break;
			
		}	// 간선의 총 개수 만큼 돌면서
		
		System.out.println(ans);
		
		
	}	// main
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
		//해당 방식이 원래 우리가 알던 코드
//		if(x == p[x]) return x;
//		return findSet(p[x]);
		
		// 위의 코드는 똑같은 작업을 또 할 수 있어서 효율이 안좋다
		// 아래는 패스 컴프레슨을 적용한 코드
		if(x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		// x와 y가 대표자 이여만 한다.
		p[findSet(y)] = findSet(x); // X그룹에 Y그룹을 넣는 것
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51";
	
}

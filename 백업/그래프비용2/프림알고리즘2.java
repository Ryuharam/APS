package 그래프비용2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class 프림알고리즘2 {
	// 우선순위 큐
	
	static class Edge implements Comparable<Edge>{
		int A, B, W;
		
		
		
		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}



		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.W, o.W);
		}
		
	}
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();	//	정점의 번호 0번부터 시작
		int E = sc.nextInt();	//	간선의 수
		
		// 인접 리스트 
		List<Edge>[] adjList = new ArrayList[V];
		
		for(int i=0 ; i<V ; i++) {
			adjList[i] = new ArrayList<>();
		}	// 실제 생성 까지
		
		for(int i=0 ; i<E ; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjList[A].add(new Edge(A,B,W));
			adjList[B].add(new Edge(B,A,W));
		}	// 입력 끝
		
		// 방문 체크
		boolean[] visited = new boolean[V];	// 해당 정점 뽑았어!
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[0] = true;
		
		int ans = 0;
		int pick = 1;
		
//		// 1.
//		for(int i=0 ; i<adjList[0].size() ; i++) {
//			pq.add(adjList[0].get(i));
//		}
//		
//		// 2.
//		for(Edge e : adjList[0])
//			pq.add(e);
		
		//3.
		pq.addAll(adjList[0]);
		
		while(pick != V) {
			Edge e = pq.poll();
			if(visited[e.B]) continue;	// 이미 뽑은 친구라면
			
			ans+= e.W;	// 비용추가
			visited[e.B] = true;
			pick++;
			
			pq.addAll(adjList[e.B]);
		}
		
		System.out.println(ans);
		
		
		
		
		
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

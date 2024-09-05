package 그래프비용2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 	최단 경로의 정의
 * 		- 가중치가 있는 그래프에서 두 정점 사이의 경로들 중 간선의 가중치의 합이 최소인 경로
 * 	하나의 시작 정점에서 끝 정점까지의 최단 경로
 * 		- 다익스트라 알고리즘 : 음의 가중치 허용X
 * 		- 벨만-포드 알고리즘 : 음의 가중치 허용 O
 * 	모든 정점들에 대한 최단 경로
 * 		- 플로이드-워셜 알고리즘 (비교적 높은 시간 복잡도. for문 3개) : for(경유지) for(출발지) for(도착지)
 * 	다익스트라 알고리즘
 * 		- 시작 정점에서 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식
 * 		- 탐욕 알고리즘 중 하나이고, 프림 알고리즘과 유사함
 * 		- 정점 A에서 정점 B 까지의 최단 경로 (A->X + X->B)
 * 	다익스트라 알고리즘 동작 과정
 * 		1. 시작 정점 입력
 * 		2. 거리 저장 배열을 무한대로 초기화
 * 		3. 시작점에서 갈 수 있는 곳의 값 갱신
 * 		4. 아직 방문하지 않은 점들이 가지고 있는 거리 값과 현재 정점에서 방문하지 않은 정점까지의 가중치의 합이 작다면 갱신
 * 		5. 모든 정점을 방문할 때까지 반복
 * 
 */

public class 다익스트라알고리즘 {
	
	// 반복문
	
	static class Node {
		int V, W;

		public Node(int v, int w) {
			super();
			V = v;
			W = w;
		}
		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;	
	static List<Node>[] adjList;	// 인접 리스트
	static int[] dist;	// 거리 배열

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i=0 ; i<V ; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for(int i=0 ; i<E ; i++) {
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}	// 입력 완료
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
		
	}
	
	private static void dijkstra(int st) {
		boolean[] visited = new boolean[V];
		
		dist[st] = 0;
		
		for(int i=0 ; i<V-1 ; i++) {
			int min = INF;
			int idx = -1;
			
			for(int j=0 ; j<V ; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true;
			
			for(Node node : adjList[idx]) {
				if(!visited[node.V] && dist[node.V] > dist[idx]+node.W) {
					dist[node.V] = dist[idx] + node.W;
				}
			}
			
		}
		
	}

	static String input = "6 11\r\n"
			+ "0 1 4\r\n"
			+ "0 2 2\r\n"
			+ "0 5 25\r\n"
			+ "1 3 8\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 4 4\r\n"
			+ "3 0 3\r\n"
			+ "3 5 6\r\n"
			+ "4 3 5\r\n"
			+ "4 5 12";

}

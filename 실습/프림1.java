package 그래프비용2;

import java.util.Arrays;
import java.util.Scanner;

/*
 *  프림 알고리즘
 *  	- 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 만들어 가는 방식
 *  		* MST(최소 신장 트리)
 *  			- 모든 정점을 연결하는 트리. 간선(가중치)
 *  		1. 임의 정점을 선택하여 시작
 *  		2. 선택한 정점과 인접하는 정점들 중의 최소 비용의 간선이 존재하는 정점을 선택
 *  		3. 모든 정점이 선택될 때 까지 2번 과정을 반복
 *  	- 서로소인 2개의 집합 정보를 유지
 *  		- 트리 정점 : MST를 만들기 위해 선택된 정점들
 *  		- 비트리 정점들 : 선택 되지 않은 정점들
 */

public class 프림알고리즘 {
	// 반복문
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();	//	정점의 번호 0번부터 시작
		int E = sc.nextInt();	//	간선의 수
		
		//	인접 행렬 방식으로
		int[][] adjArr = new int[V][V];
		
		for(int i=0 ; i<E ; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W;	// 무향
			
		}	// 입력 끝
		
		// 방문 체크
		boolean[] visited = new boolean[V];	// 해당 정점 뽑았어!
		int[] p = new int[V]; 		//  내 부모는... 사용하지 않을 거라면 굳이 작성하지 않아도 OK
		int[] dist = new int[V];	// 아까 key라고 표현했던 선택한 간선의 가중치
		
		// 프림 제 1장 : 초기화
		for(int i=0 ; i<V ; i++) {
			p[i] = -1;	// 0 번 정점도 사용하니까...
			dist[i] = INF;
		}
		
//		Arrays.fill(dist, INF); // 멋은 있지만 하지만 똑같다
		
		// 프림 제 2장 : 시작 정점을 결정
		
		dist[0] = 0;
		
		// 프림 제 3장 ; 가중치 배열을 돌면서 가장 값이 낮은 것을 골라서 방문 체크 / 갱신
		for(int i=0 ; i<V-1 ; i++) {	// V번 돌아도 괜찮다
			int min = INF;
			int idx = -1;
			// 방문하지 않았으면서 가장 작은 값 가져와
			for(int j=0 ; j<V ; j++) {
				if(!visited[j] & dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}	// 해당 반복문이 종료가 되면... idx는 가장 작은 값을 가지고 있다. (방문X)
			visited[idx] = true;	// 방문처리
			// 방문하지 않았고 갱신할 수 있으면 갱신해
			for(int j=0 ; j<V ; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;	// 필요시
				}
			}
		}	// 끝
		
		int ans = 0;
		for(int i=0 ; i<V ; i++) {
			ans += dist[i];
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

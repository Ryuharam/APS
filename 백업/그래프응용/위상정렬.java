package 그래프응용;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬 {
	
	/*
	 *  위상 정렬이란
	 *  	- 순서가 있는 작업을 차례로 진행해야 할 때 순서를 결정해 주기 위해 사용하는 알고리즘
	 *  	- 사이클 없는 방향 그래프의 모든 노드를 주어진 방향성에 어긋나지 않게 순서를 나열하는 것
	 *  	- DAG(Directed Acyclic Graph)
	 *  	- ex) 대학 선수과목, 공장의 작업 순서, 요리 순서 ... 등
	 *  사전 지식
	 *  	- DAG(Directed Acyclic Graph : 유향 비사이클 그래프)
	 *  	- 진입 차수 : 특정 노드로 들어오는 간선의 개수
	 *  	- 진출 차수 : 특정 노드에서 나가는 간선의 개수
	 *  
	 *  위상 정렬 방법 (Queue 사용)
	 *  	1. 진입 차수가 0인 모든 노드를 Queue에 삽입
	 *  	2. Queue가 공백상태가 될 때까지 반복 수행
	 *  		1) Queue 에서 원소를 꺼내 해당 노드에서 나가는 간선을 그래프에서 제거한다.
	 *  			(연결 된 노드의 진입 차수를 감소 시킨다.)
	 *  		2) 새롭게 진입 차수가 0이 된 노드를 Queue에 삽입한다.
	 *  	Queue 에서 꺼내지는 순서 (Queue 에 들어오는 순서) 가 정렬을 수행한 결과
	 *  
	 *  위상 정렬 특징
	 *  	- 모든 정점을 방문하기 전에 Queue가 공백 상태가 되면 사이클이 존재하는 것이다.
	 *  		(사이클이 존재하면 진입 차수가 0이 될 수 없음)
	 *  	- 그래프의 유형은 DAG
	 *  	- 여러 해담이 존재할 수 있다
	 *  		(진입차수가 0인 값이 동시에 생성이 된다면 작성한 코드 방법에 따라 답이 달라진다)
	 *  	- 시간 복잡도 O(V+E)
	 *  
	 *  
	 *  
	 */ 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 점점의 개수
		int E = sc.nextInt(); // 간선의 개수
		
		int[][] adjArr = new int[V+1][V+1];
		int[] degree = new int[V+1];	// 진입 차수를 저장할 배열
		
		for(int i=0 ; i<E ; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = 1;	// 가중치는 따로 없으니까 1로 표기
			degree[B]++;		// 진입 차수 증가!
		} // 입력 완료
		
		// 위상 정렬 큐 1장 : 진입차수가 0인 친구들을 몽땅 넣어라
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1 ; i<V+1 ; i++) {
			if(degree[i]==0) {
				queue.add(i);
			}
		}
		
		// 위상 정렬 큐 2장 : 큐가 공백상태가 될 때까지 진행
		// 간선을 제거하고, 진입차수가 0이 되면 새롭게 큐에 넣는다.
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.println(cook[curr]);		// 위상 정렬 수행한 결과
			
			for(int i=1 ; i < V+1 ; i++) {
				// 무향에서는 인덱스의 순서가 중요하지 않지만
				// 유향에서는 인텍스의 순서가 중요하다
				if(adjArr[curr][i]==1) {
					degree[i]--;	// 진입차수 하나 깎아
					adjArr[curr][i] = 0; // 방향이 있기 때문에 하지 않아도 된다.
					// 만약 이번에 i 정점의 진입차수가 0이 되었다면
					if(degree[i]==0) {
						queue.add(i);
					}
				}
			}
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	
	public static String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7";
	
}

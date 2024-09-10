// 입력
//  (테스트 케이스)
//  (과목 수)
//  (1 과목의 선수과목 수) (1과목의 선수 과목들) ...
//  (2 과목의 선수과목 수) (2과목의 선수 과목들) ...
//  ...

// 출력
//  모든 과목을 듣는데 필요한 학기 수
//  같은 학기에 여러 과목 들을 수 있다
//  만약 모든 과목을 듣지 못한다면 -1 출력

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 선수과목 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = sc.nextInt();	// 과목 수
			int[] degree = new int[N+1];
			
			List<Integer>[] adjList = new LinkedList[N+1];
			
			for(int i=1 ; i<=N ; i++) {
				adjList[i] = new LinkedList();
			}
			
			for(int i=1 ; i<=N ; i++) {		// i 과목의 정보 저장
				int n = sc.nextInt();		// i 과목의 선수 과목 수
				degree[i] = n;
				for(int j=0 ; j<n ; j++) {
					int prev = sc.nextInt();	// i 과목의 선수과목
					adjList[prev].add(i);
				}
			}
			
			// 위상 정렬
			Queue<int[]> queue = new LinkedList<>();	// int[]{ 과목, 학기 }
			
			for(int i=1 ; i<=N ; i++) {
				if(degree[i]==0) {
					queue.add(new int[] {i,1});
				}
			}
			
			int classCnt = N;
			int level = 1;
			
			while(!queue.isEmpty()) {
				int[] curr = queue.poll();
				level = curr[1];
				classCnt--;
				
				for(int next : adjList[curr[0]]) {
					degree[next]--;
					
					if(degree[next]==0) {
						queue.add(new int[] {next, level+1});
					}
				}
			}
			int answer = level;
			
			if(classCnt>0) {
				answer = -1;
			}
			
			System.out.println("#"+tc+" "+answer);
			
			
		}
		
		
	}

}


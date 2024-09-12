package 그래프비용1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 점심식사시간2 {
	
	static int N;	//	한 변의 길이 
	static int[][] room;	//	방 
	static List<int[]> people;	// 사람의 좌표들 {r,c}
	static int len;		// 사람들 수
	static int[][] length;	// 사람들의 각 계단까지의 거리
	static int[][] stairs;	// 두 계단 좌표, 크기 저장 {r,c,size}
	static int answer;	// 답

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1 ; tc<=T ; tc++) {
			
			N = sc.nextInt();
			room = new int[N][N];
			stairs = new int[2][3];
			answer = Integer.MAX_VALUE;
			
			int idx = 0;	// stairs 인덱스
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					room[i][j] = sc.nextInt();
					if(room[i][j]==1) {			// 사람일 경우
						int[] tmp = {i,j};
						people.add(tmp);
					}
					
					if(room[i][j]>1) {			// 계단일 경우
						stairs[idx][0] = i;
						stairs[idx][1] = j;
						stairs[idx++][2] = room[i][j];
					}
				}
			}	//room, people, stairs 입력 완료
			
			int len = people.size();	// 사람들 수
			length = new int[2][len];
			
			// 각 계단까지의 거리 저장 : length
			findLength();
			
			// 거리들을 나누어 계산
			List<Integer> aStr = new LinkedList<>();
			List<Integer> bStr = new LinkedList<>();
			choose(0, aStr,bStr);
			
			System.out.println("#"+tc+" "+answer);
			
			
		}	// 테스트 케이스 끝
		
		
		
	}	// main 끝
	
	
	// idx : 사람의 인덱스, aStr : 0번 계단 선택 시 거리들, bStr : 1번 계단 선택 시 거리들
	private static void choose(int idx, List<Integer> aStr, List<Integer> bStr) {
		if(idx==len) {
			// 각 계단 이용시간 계산
			int time1 = cal(aStr);
			int time2 = cal(bStr);
			
			// 최소 값 갱신
			answer = Math.min(answer, Math.max(time1, time2));
			return;
		}
		
		// idx번째 사람이 0번 계단 선택
		aStr.add(length[0][idx]);
		choose(idx+1, aStr, bStr);
		aStr.remove(length[0][idx]);
		
		// idx번째 사람이 1번 계단 선택
		bStr.add(length[1][idx]);
		choose(idx+1, aStr, bStr);
		bStr.remove(length[1][idx]);
		
	}



	private static int cal(List<Integer> Str) {
		
		
		
		
		return 0;
	}


	private static void findLength() {
		// 0번 계단 좌표
		int sr1 = stairs[0][0];
		int sc1 = stairs[0][1];
		
		// 1번 계단 좌표
		int sr2 = stairs[1][0];
		int sc2 = stairs[1][1];
		
		for(int i=0 ; i<len ; i++) {
			// 사람 좌표
			int r = people.get(i)[0];
			int c = people.get(i)[1];
			// 각 계단 까지의 거리
			length[0][i] = Math.abs(sr1-r)+Math.abs(sc1-c);
			length[1][i] = Math.abs(sr2-r)+Math.abs(sc2-c);
		}
	}

}

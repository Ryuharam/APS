package 알고리즘응용_문제풀이;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 점심식사시간 {
	
	static class Coor{
		int r;
		int c;
		Coor(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int N; // 한 변의 길이
	static int M; // 사람의 수
	static int[][] room; // 방의 정보
	static List<Coor> people;	//	사람들의 좌표
	static Coor[] stair;	// 계단의 좌표
	static int[] choice;
	static int[] arriveTime;
	static int[] usingPeople;
	static int answer;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			N = sc.nextInt();
			room = new int[N][N];
			people = new LinkedList<>();
			stair = new Coor[2];
			
			int idx = 0;
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					int tmp = sc.nextInt();
					room[i][j] = tmp;
					if(tmp==1) {	// 사람인 경우
						people.add(new Coor(i,j));
					}else if(tmp>1) {
						stair[idx++] = new Coor(i,j);
					}
					
				}
			}
			
			M = people.size();
			choice = new int[M]; // 각 사람의 계단 선택
			answer = Integer.MAX_VALUE;	// 초기화
			
			dfs(0);
			
			System.out.println("#"+tc+" "+answer);
			
		}
		
		
		
	}

	private static void dfs(int idx) {
		if(idx==M) {
			cal();
			return;
		}
		
		for(int sIdx=0 ; sIdx<2 ; sIdx++) {
			choice[idx] = sIdx;
			dfs(idx+1);
		}
		
		
	}

	private static void cal() {
		
		int totalTime = 0;
		
		for(int sIdx=0 ; sIdx<2 ; sIdx++) {
			arriveTime = new int[2*N+2];
			usingPeople = new int[2*N+N*N]; 
			int time = Integer.MAX_VALUE;
			for(int i=0 ; i<M ; i++) {
				if(sIdx==choice[i]) {
					int tmp = dis(people.get(i),choice[i]) + 1 ; // i번째 사람이 계단으로 이동해서 진입하기까지의 시간
					arriveTime[tmp]++;
					time = Math.min(time, tmp);
				}
			}
			if(time==Integer.MAX_VALUE) continue;	// 모두 다른 계단 선택했을 경우

			int usingTime = time;	//	처음 계단 진입하는 시간
			int stairLength = room[stair[sIdx].r][stair[sIdx].c];	// 계단 길이
			
			for(int i=1 ; i<2*N ; i++) {
				while(arriveTime[i]>0) {
					arriveTime[i]--;
					int useStair = stairLength;
					for(int j=i ; j<2*N+N*N ; j++) {
						if(usingPeople[j]<3) {	// j시간에 이용중인 사람이 3명보다 적은 경우
							usingPeople[j]++;
							useStair--;
						}
						
						if(useStair==0) {
							usingTime = Math.max(usingTime, j+1);
							break;
						}
					}
				}
			}
			totalTime = Math.max(totalTime, usingTime);	// 두 계단의 시간 비교
		}
		// 각 choice 경우에서 최소 값 구하기
		answer = Math.min(answer, totalTime);
		
		
	}

	private static int dis(Coor person, int sIdx) {
		return Math.abs(person.r - stair[sIdx].r) + Math.abs(person.c - stair[sIdx].c); 
	}

}

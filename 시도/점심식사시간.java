package 그래프비용1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 점심식사시간 {
	
	static class floor{
		floor next;
		floor prev;
		int[] person;
		
		floor(){}
		floor(int[] person){
			this.person = person;
		}
	}
	
	static class stair{
		floor start;
		floor finish;
		int size;
		int cnt;
		int r;
		int c;
		
		stair(int size, int r, int c){
			finish.next = start;
			start.prev = finish;
			this.size = size;
			this.r = r;
			this.c = c;
		}
		
		void addP(int[] person){
			floor p = new floor(person);
			p.prev = start.prev;
			p.next = start;
			start.prev.next = p;
			start.prev = p;
			cnt++;
		}
		
		void removeP() {
			finish.next.next.prev = finish;
			finish.next = finish.next.next;
			cnt--;
		}
		
		boolean isEmpty() {
			if(cnt==0)
				return true;
			return false;
		}
		
		boolean isFull() {
			if(cnt==size)
				return true;
			return false;
		}
		
		
	}
	
	static int pCnt;
	static stair[] stairs = new stair[2];
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String N = br.readLine();
			int n = Integer.parseInt(N);
			
			int sidx = 0;	// stairs 인덱스
			pCnt = 0;
			
			for(int r=0 ; r<n ; r++) {
				String row = br.readLine();
				StringTokenizer st = new StringTokenizer(row);
				for(int c=0 ; c<n ; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					
					if(tmp==1) {	// 사람인 경우
						pCnt++;
					}
					
					if(tmp>1) {		// 계단인 경우
						stair newStair = new stair(r,c,tmp);
						stairs[sidx++] = newStair;
					}
				}
			}
			
			
			
			answer = Integer.MAX_VALUE;
			
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		
		String ans = sb.toString();
		System.out.println(ans);
		
		
	}


}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		// 방의 개수
		int N = Integer.parseInt(st1.nextToken());
		// 용사의 초기 공격력
		long A = Long.parseLong(st1.nextToken());
		// 최대 생명력 구할 변수
		long H = 0;
		
		
		// 방을 이동하며 최대 생명력 구하기
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			// i번 쩨 방의 정보
			// 1 : 몬스터, 2 : 포션
			int t1 = Integer.parseInt(st2.nextToken());
			// 몬스터의 공격력 or 용사의 공격력 증가량
			long a = Long.parseLong(st2.nextToken());
			// 몬스터의 생명력 or 용사의 생명력 증가량
			long h = Long.parseLong(st2.nextToken());
			
			if(t1==1) {
				// 몬스터라면
				// 용사의 공격 횟수
				long cnt = h/A;
				if(h%A==0) {
					cnt -= 1;
				}
				// 몬스터의 공격
				H += cnt*a;
				H++;
			}else {
				// 포션이라면
				// 용사 공격력 증가
				A += a;
				// 용사 생명력 증가
				H -= h;
			}
		
		}
		
		System.out.println(H);
		
		
	}

}

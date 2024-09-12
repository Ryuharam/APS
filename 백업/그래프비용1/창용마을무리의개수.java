package 그래프비용1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 창용마을무리의개수 {
	
	static int[] p;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			p = new int[V+1];
			
			for(int i=1 ; i<=V ; i++) {
				p[i] = i;
			}
			
			for(int i=0 ; i<E ; i++) {
				
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				int pa = findSet(A);
				int pb = findSet(B);
				
				if(pa > pb) {
					p[pa] = pb;
				}else {
					p[pb] = pa;
				}
				
			}
			
//			System.out.println("갱신 전");
//			System.out.println(Arrays.toString(p));
			
			for(int i=1 ; i<=V ; i++) {	// 갱신
				p[i] = findSet(p[i]);
			}
			
//			System.out.println("갱신 후");
//			System.out.println(Arrays.toString(p));
			
			Set<Integer> cnt = new HashSet<>();
			
			for(int i=1 ; i<=V ; i++) {
				cnt.add(p[i]);
			}
			
			int answer = cnt.size();
			
			System.out.println("#"+tc+" "+answer);
			
		}
		
		
		
	}

	private static int findSet(int a) {
		if(a != p[a]) {
			p[a] = findSet(p[a]);
		}
		return p[a];
	}

}

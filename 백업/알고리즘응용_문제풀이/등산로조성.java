package 알고리즘응용_문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class 등산로조성 {
	
	static int N, K;
	static int[][] mountain;
	static boolean[][] visited;
	static int answer;
	// 상 우 하 좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			N = sc.nextInt();	// 한 변의 길이
			K = sc.nextInt();	// 깎을 수 있는 높이
			answer = 0;
			
			mountain = new int[N][N];
			int max = 0;
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					mountain[i][j] = sc.nextInt();
					max = Math.max(max, mountain[i][j]);
				}
			}
			
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(mountain[i][j]==max) {
						visited = new boolean[N][N];
						visited[i][j] = true;
						track(i,j,1,true);
						visited[i][j] = false;
					}
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		} // tc
		
		String answer = sb.toString();
		System.out.println(answer);
		sc.close();
		
	} // main

	private static void track(int r, int c, int cnt, boolean skill) {
		
		answer = Math.max(answer, cnt);
		
		visited[r][c] = true;
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isOk(nr, nc)) continue;
			
			// 이동 가능
			if(mountain[nr][nc]<mountain[r][c]) {
				track(nr,nc,cnt+1,skill);
			}
			
			// 깎아서 이동
			else if( mountain[nr][nc] >= mountain[r][c] && mountain[nr][nc]-K < mountain[r][c] && skill) {
				int tmp = mountain[nr][nc];
				mountain[nr][nc] = mountain[r][c]-1;
				track(nr, nc, cnt+1, false);
				mountain[nr][nc] = tmp;
			}
		}
		
		visited[r][c] = false;
		
	}

	private static boolean isOk(int nr, int nc) {
		
		return (nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]);
	}

}

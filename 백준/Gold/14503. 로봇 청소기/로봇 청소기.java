import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	// 방 정보
	static int N;
	static int M;
	static int[][] room;
	
	// 상, 우, 하, 좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	//현재 로봇의 상태
	static int r;
	static int c;
	static int d;
	
	// 청소한 칸의 개수
	static int clean;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String nm = br.readLine();
		StringTokenizer st1 = new StringTokenizer(nm);
		
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		room = new int[N][M];
		
		String rcd = br.readLine();
		StringTokenizer st2 = new StringTokenizer(rcd);
		
		r = Integer.parseInt(st2.nextToken());
		c = Integer.parseInt(st2.nextToken());
		d = Integer.parseInt(st2.nextToken());
		
		for(int i=0 ; i<N ; i++) {
			String row = br.readLine();
			StringTokenizer st3 = new StringTokenizer(row);
			for(int j=0 ; j<M ; j++) {
				room[i][j] = Integer.parseInt(st3.nextToken());
			}
		}
		
		clean = 0;
		
		run();
		
		System.out.println(clean);
		
	}


	private static void run() {
		
		if(room[r][c]==0) {
			clean++;
			room[r][c] = 2;
		}
		
		if(check()) {
			d = (d-1+4)%4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc]==0) {
				r = nr;
				c = nc;
				run();
			}else{
				run();
			}
			
		}else {
			int nr = r - dr[d];
			int nc = c - dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc]!=1) {
				r = nr;
				c = nc;
				run();
			}else {
				return;
			}
		}
		
		
	}


	private static boolean check() {
		
		int tmpD = d;
		
		int nr = r + dr[tmpD];
		int nc = c + dc[tmpD];

		for(int i=0 ; i<4 ; i++) {
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc]==0) {
				return true;
			}
			
			tmpD = (tmpD-1+4)%4;
			nr = r + dr[tmpD];
			nc = c + dc[tmpD];
		}
		
		return false;
	}

	
}

import java.io.*;
import java.util.*;

public class Main {
    
    static int N, B, W;
    static int[][] num;
    static boolean[][] visited;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        B = 0;
        W = 0;
        num = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        btk(0, 0, 0, 0);
        btk(0, 1, 1, 0);
        
        System.out.println(B+W);
		
	}
    
    static void btk(int r, int c, int type, int cnt){
        if(r >= N){
            if(type == 0){
                B = Math.max(B,cnt);
            }else{
                W = Math.max(W,cnt);
            }
            return;
        }
        
        int next = r*N + c + 1;
        int nextR = next / N;
        int nextC = next % N;
        
        if(num[r][c] == 0){
            btk(nextR, nextC, type, cnt);
            return;
        }
        
        if((r+c)%2 == type && isPossible(r,c)){
            visited[r][c] = true;
            btk(nextR, nextC, type, cnt+1);
            visited[r][c] = false;
        }
        
        btk(nextR, nextC, type, cnt);
    }
    
    static boolean isPossible(int r, int c){
        if(num[r][c] == 0) return false;

        int[] dr = {-1, -1};
        int[] dc = {-1, 1};

        for(int d=0 ; d<2 ; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            while(nr>=0 && nr<N && nc>=0 && nc<N){
                if(visited[nr][nc]) return false;
                nr += dr[d];
                nc += dc[d];
            }
        }
        
        return true;
    }
}
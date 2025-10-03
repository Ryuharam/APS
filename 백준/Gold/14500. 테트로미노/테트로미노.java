import java.util.*;
import java.io.*;

public class Main{
    
    static int N,M,answer,max;
    static int[][] board;
    static boolean[][] visited;
    
    static final int[] dr = {0,1,0,-1};
    static final int[] dc = {1,0,-1,0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }
        
        answer = 0;
        
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                visited[i][j] = true;
                dfs(i,j,1,board[i][j]);
                visited[i][j] = false;
                
                checkT(i,j);
            }
        }
        
        System.out.println(answer);
        
    }
 
    static void dfs(int r, int c, int cnt, int sum){       
        if(sum + max*(4-cnt) <= answer) return;
        
        if(cnt==4){
            answer = Math.max(answer,sum);
            return;
        }
        
        for(int d=0 ; d<4 ; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(isIn(nr,nc) && !visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr,nc,cnt+1,sum+board[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }
    
    static void checkT(int r, int c){
        for(int d=0 ; d<4 ; d++){
            int nr1 = r + dr[d];
            int nc1 = c + dc[d];
            int nr2 = r + dr[(d+1)%4];
            int nc2 = c + dc[(d+1)%4];
            int nr3 = r + dr[(d+2)%4];
            int nc3 = c + dc[(d+2)%4];
            
            if(isIn(nr1,nc1) && isIn(nr2,nc2) && isIn(nr3,nc3)){
                answer = Math.max(answer, board[r][c]+board[nr1][nc1]+board[nr2][nc2]+board[nr3][nc3]);
            }
        }
    }
    
    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}
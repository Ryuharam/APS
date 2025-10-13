import java.io.*;
import java.util.*;

public class Main {
    
    static int R,C,ans;
    static char[][] board;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        board = new char[R][C];
        boolean[] isUsed = new boolean[26];
        boolean[][] visited = new boolean[R][C];
        ans = 0;
        
        for(int r=0 ; r<R ; r++){
            String row = br.readLine();
            for(int c=0 ; c<C ; c++){
                board[r][c] = row.charAt(c);
            }
        }
        
        visited[0][0] = true;
        isUsed[board[0][0]-65] = true;
        
        btk(0,0,isUsed,visited,1);
        
        System.out.println(ans);
        
    }
    
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    
    static void btk(int r, int c, boolean[] isUsed, boolean[][] visited, int cnt){
        ans = Math.max(ans, cnt);
        
        for(int d=0 ; d<4 ; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc] && !isUsed[board[nr][nc]-65]){
                visited[nr][nc] = true;
                isUsed[board[nr][nc]-65] = true;
                btk(nr,nc,isUsed,visited,cnt+1);
                visited[nr][nc] = false;
                isUsed[board[nr][nc]-65] = false;
            }
        }
        
    }
}
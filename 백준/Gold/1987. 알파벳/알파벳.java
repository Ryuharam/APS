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
        ans = 0;
        
        for(int r=0 ; r<R ; r++){
            String row = br.readLine();
            for(int c=0 ; c<C ; c++){
                board[r][c] = row.charAt(c);
            }
        }
        
        isUsed[board[0][0]-65] = true;
        
        btk(0,0,isUsed,1);
        
        System.out.println(ans);
        
    }
    
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    
    static void btk(int r, int c, boolean[] isUsed, int cnt){
        ans = Math.max(ans, cnt);
        
        if(cnt>=26) return;
        
        for(int d=0 ; d<4 ; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr>=0 && nr<R && nc>=0 && nc<C && !isUsed[board[nr][nc]-65]){
                isUsed[board[nr][nc]-65] = true;
                btk(nr,nc,isUsed,cnt+1);
                isUsed[board[nr][nc]-65] = false;
            }
        }
        
    }
}
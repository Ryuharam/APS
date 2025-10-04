import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][3];
        int[][] min = new int[N][3];
        int[][] max = new int[N][3];
        
        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }
        
        min[0][0] = max[0][0] = board[0][0];
        min[0][1] = max[0][1] = board[0][1];
        min[0][2] = max[0][2] = board[0][2];
        
        for(int i=1 ; i<N ; i++){
            min[i][0] = Math.min(min[i-1][0],min[i-1][1]) + board[i][0];
            max[i][0] = Math.max(max[i-1][0],max[i-1][1]) + board[i][0];
            
            min[i][1] = Math.min(min[i-1][0], Math.min(min[i-1][1],min[i-1][2])) + board[i][1];
            max[i][1] = Math.max(max[i-1][0], Math.max(max[i-1][1],max[i-1][2])) + board[i][1];
            
            min[i][2] = Math.min(min[i-1][1],min[i-1][2]) + board[i][2];
            max[i][2] = Math.max(max[i-1][1],max[i-1][2]) + board[i][2];
        }
        
        int ans1 = Math.max(max[N-1][0],Math.max(max[N-1][1],max[N-1][2]));
        int ans2 = Math.min(min[N-1][0],Math.min(min[N-1][1],min[N-1][2]));
        
        System.out.println(ans1+" "+ans2);
        
        
    }
}
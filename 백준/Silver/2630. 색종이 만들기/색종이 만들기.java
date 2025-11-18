import java.io.*;
import java.util.*;

public class Main{
    static int blue,white;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count(board, 0, N-1,0,N-1);
        System.out.println(white);
        System.out.println(blue);
    }
    static void count(int[][] board, int r_start, int r_end, int c_start, int c_end){
        int color = check(board, r_start, r_end, c_start, c_end);
        if(color==-1){
            count(board, r_start, (r_start+r_end)/2, c_start, (c_start+c_end)/2);
            count(board, (r_start+r_end)/2+1, r_end, c_start, (c_start+c_end)/2);
            count(board, r_start, (r_start+r_end)/2, (c_start+c_end)/2+1, c_end);
            count(board, (r_start+r_end)/2+1, r_end, (c_start+c_end)/2+1, c_end);
        }else{
            if(color==0){
                white++;
            }else{
                blue++;
            }
        }
    }
    
    static int check(int[][] board, int r_start, int r_end, int c_start, int c_end){
        int tmp = board[r_start][c_start];
        for(int i=r_start ; i<=r_end ; i++){
            for(int j=c_start ; j<=c_end ; j++){
                if(tmp!=board[i][j]) return -1;
            }
        }
        return tmp;
    }
}
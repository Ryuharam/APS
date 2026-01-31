import java.io.*;
import java.util.*;

public class Main {

    static int N, max;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        max = 0;
        board = new int[N][N];

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(0, board);

        System.out.println(max);

    }

    static void move (int cnt , int[][] board){
        if(cnt == 5){

            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        // 상
        int[][] up = moveUp(board);
        move(cnt+1, up);

        // 하
        int[][] down = moveDown(board);
        move(cnt+1, down);

        // 좌
        int[][] left = moveLeft(board);
        move(cnt+1, left);

        // 우
        int[][] right = moveRight(board);
        move(cnt+1, right);

    }

    static int[][] moveUp(int[][] board){
        int[][] res = new int[N][N];

        for(int c=0 ; c<N ; c++){
            int idx = 0;
            int last = 0;
            boolean merged = false;

            for(int r=0 ; r<N ; r++){
                int curr = board[r][c];

                if(curr == 0) continue;

                if(!merged && curr == last){
                    res[idx-1][c] = curr * 2;
                    merged = true;
                    last = curr * 2;
                }else{
                    res[idx++][c] = curr;
                    last = curr;
                    merged = false;
                }
            }

        }

        return res;
    }

    static int[][] moveDown(int[][] board){
        int[][] res = new int[N][N];

        for(int c=0 ; c<N ; c++){
            int idx = N-1;
            int last = 0;
            boolean merged = false;

            for(int r=N-1 ; r>=0 ; r--){
                int curr = board[r][c];
                if(curr == 0) continue;

                if(!merged && last == curr){
                    res[idx+1][c] = curr * 2;
                    last = curr * 2;
                    merged = true;
                }else{
                    res[idx--][c] = curr;
                    last = curr;
                    merged = false;
                }
            }
        }

        return res;
    }

    static int[][] moveLeft(int[][] board){
        int[][] res = new int[N][N];

        for(int r=0 ; r<N ; r++){
            int idx = 0;
            int last = 0;
            boolean merged = false;

            for(int c=0 ; c<N ; c++){
                int curr = board[r][c];
                if(curr == 0) continue;
                if(!merged && last == curr){
                    res[r][idx-1] = curr * 2;
                    last = curr * 2;
                    merged = true;
                }else{
                    res[r][idx++] = curr;
                    last = curr;
                    merged = false;
                }
            }
        }

        return res;
    }

    static int[][] moveRight(int[][] board){
        int[][] res = new int[N][N];

        for(int r=0 ; r<N ; r++){
            int idx = N-1;
            int last = 0;
            boolean merged = false;

            for(int c=N-1 ; c>=0 ; c--){
                int curr = board[r][c];
                if(curr == 0) continue;

                if(!merged && curr == last){
                    res[r][idx+1] = curr * 2;
                    last = curr * 2;
                    merged = true;
                }else{
                    res[r][idx--] = curr;
                    last = curr;
                    merged = false;
                }
            }

        }
        return res;
    }


}
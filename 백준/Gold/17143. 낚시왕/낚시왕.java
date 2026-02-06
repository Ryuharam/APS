import java.io.*;
import java.util.*;

public class Main {

    // 1 <= R,C <= 100, 0<= M <= R*C
    static int R, C, M;
    static int[] dr = {0,-1,1,0,0};
    static int[] dc = {0,0,0,1,-1};

    static class Shark {
        int r;    // 1 <= r <= R
        int c;    // 1 <= c <= C
        int speed;    // 0 <= speed <= 1_000
        int d;    // 위, 아래, 오른쪽, 왼쪽
        int size; // 1 <= size <=10_000

        Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.speed = s;
            this.d = d;
            this.size = z;
        }
    }

    static Shark[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new Shark[R+1][C+1];

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r,c,s,d,z);
            board[r][c] = shark;
        }

        int sum = 0;

        for(int c=1 ; c<= C ; c++){
            // 상어 잡기
            for(int r=1 ; r<= R ; r++){
                if(board[r][c] == null) continue;
                sum += board[r][c].size;
                board[r][c] = null;
                break;
            }

            // 상어 이동
            Shark[][] newBoard = new Shark[R+1][C+1];
            for(int i=1 ; i<=R ; i++){
                for(int j=1 ; j<=C ; j++){
                    if(board[i][j] == null) continue;
                    Shark s = board[i][j];

                    int move = s.speed;
                    if(s.d == 1 || s.d == 2){
                        move %= (R-1)*2;
                    }else {
                        move %= (C-1)*2;
                    }

                    int nr = s.r;
                    int nc = s.c;
                    int nd = s.d;

                    for(int m=0 ; m<move ; m++){
                        if(nc == 1 && nd == 4) nd = 3;
                        else if(nc == C && nd == 3) nd = 4;
                        else if(nr == 1 && nd == 1) nd = 2;
                        else if(nr == R && nd == 2) nd = 1;

                        nr += dr[nd];
                        nc += dc[nd];
                    }

                    s.r = nr;
                    s.c = nc;
                    s.d = nd;

                    if(newBoard[nr][nc] == null || newBoard[nr][nc].size < s.size){
                        newBoard[nr][nc] = s;
                    }
                }
            }
            board = newBoard;

        }

        System.out.println(sum);
    }

}
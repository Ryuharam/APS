import java.io.*;
import java.util.*;

public class Main {

    static int N, M, ans;
    static char[][] board;
    static boolean[][][][] visited;
    // 하, 우, 상, 좌
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 11;
        board = new char[N][M];

        int[] red = new int[2];
        int[] blue = new int[2];

        for(int i=0 ; i<N ; i++){
            String line = br.readLine();
            for(int j=0 ; j<M ; j++){
                char c = line.charAt(j);
                if(c == 'R'){
                    red[0] = i;
                    red[1] = j;
                    board[i][j] = '.';
                }else if (c == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                    board[i][j] = '.';
                }else{
                    board[i][j] = c;
                }
            }
        }

        dfs(0, red[0], red[1], blue[0], blue[1]);

        System.out.println(ans == 11 ? -1 : ans);
    }

    static void dfs(int cnt, int rr, int rc, int br, int bc){
        if(cnt >= ans) return;
        if(cnt > 10) return;

        // d : 하, 우, 상, 좌
        for(int d=0 ; d<4 ; d++){
            boolean blueFirst = (d==0 && br > rr) ||
                    (d==1 && bc > rc) ||
                    (d==2 && br < rr) ||
                    (d==3 && bc < rc);

            MoveResult redRes;
            MoveResult blueRes;

            if(blueFirst) {
                blueRes = move(br,bc,d,-1,-1);
                if(blueRes.inHole) continue;

                redRes = move(rr, rc, d, blueRes.r, blueRes.c);
                if(redRes.inHole){
                    ans = Math.min(ans, cnt + 1);
                    continue;
                }
            }else{
                redRes = move(rr, rc, d, -1, -1);
                if(redRes.inHole){
                    blueRes = move(br, bc, d, -1, -1);
                    if(blueRes.inHole) continue;
                    ans = Math.min(ans, cnt+1);
                    continue;
                }
                blueRes = move(br, bc, d, redRes.r, redRes.c);
                if(blueRes.inHole) continue;
            }

            dfs(cnt+1, redRes.r, redRes.c, blueRes.r, blueRes.c);
        }

    }

    static class MoveResult {
        int r, c;
        boolean inHole;

        MoveResult(int r, int c, boolean inHole){
            this.r = r;
            this.c = c;
            this.inHole = inHole;
        }
    }

    static MoveResult move(int r, int c, int d, int blockR, int blockC) {
        while(true){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(board[nr][nc] == '#') break;
            if(nr == blockR && nc == blockC) break;

            r = nr;
            c = nc;

            if(board[r][c] == 'O'){
                return new MoveResult(r,c,true);
            }
        }
        return  new MoveResult(r,c,false);
    }


}
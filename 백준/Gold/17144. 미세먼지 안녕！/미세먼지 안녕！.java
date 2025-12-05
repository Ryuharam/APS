import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int R, C, T;
    static int[][] room;

    static int up;
    static int down;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        up = -1;
        down = -1;

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1) {
                    if(up == -1) up = i;
                    else down = i;
                }
            }
        }

        for(int t=0; t < T; t++){
            diffuse();
            runAir();
        }

        int ans = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(room[i][j] > 0 ){
                    ans += room[i][j];
                }
            }
        }
        System.out.println(ans);
    }

    private static void runAir() {

        for(int r=up-1 ; r>0 ; r--){
            room[r][0] = room[r-1][0];
        }

        for(int c=0; c<C-1; c++){
            room[0][c] =  room[0][c+1];
        }

        for(int r=0 ; r<up ; r++){
            room[r][C-1] = room[r+1][C-1];
        }

        for(int c=C-1 ; c>1 ; c--){
            room[up][c] = room[up][c-1];
        }

        room[up][1] = 0;

        for(int r=down+1 ; r<R-1 ; r++){
            room[r][0] = room[r+1][0];
        }

        for(int c=0; c<C-1; c++){
            room[R-1][c] =   room[R-1][c+1];
        }

        for(int r=R-1 ; r>down ; r--){
            room[r][C-1] = room[r-1][C-1];
        }

        for(int c=C-1 ; c>1 ; c--){
            room[down][c] = room[down][c-1];
        }

        room[down][1] = 0;
    }

    private static void diffuse() {
        int[][] add = new int[R][C];

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(room[r][c] <= 0) continue;

                int dust = room[r][c];
                int spread = dust/5;
                if(spread == 0) continue;

                int cnt = 0;

                for(int d=0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(nr<0 || nr >= R || nc<0 || nc >= C) continue;
                    if(room[nr][nc] == -1) continue;

                    add[nr][nc] += spread;
                    cnt++;
                }

                room[r][c] -= spread*cnt;
            }
        }

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(room[r][c] == -1) continue;
                room[r][c] += add[r][c];
            }
        }
    }
}
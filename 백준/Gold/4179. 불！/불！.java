import java.io.*;
import java.util.*;

public class Main {

    static int R, C, min;
    static char[][] board;
    static int[][] fireDist, jDist;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        fireDist = new int[R][C];
        jDist = new int[R][C];

        Queue<int[]> fq = new LinkedList<>();
        Queue<int[]> jq = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
                fireDist[i][j] = -1;
                jDist[i][j] = -1;

                if(board[i][j] == 'F') {
                    fq.add(new int[] {i, j});
                    fireDist[i][j] = 0;
                }
                if(board[i][j] == 'J') {
                    jq.add(new int[] {i, j});
                    jDist[i][j] = 0;
                }
            }
        }

        while(!fq.isEmpty()) {
            int[] curr = fq.poll();
            for(int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if(fireDist[nr][nc] != -1 || board[nr][nc] == '#') continue;
                fireDist[nr][nc] = fireDist[curr[0]][curr[1]] + 1;
                fq.add(new int[] {nr, nc});
            }
        }

        while(!jq.isEmpty()) {
            int[] curr = jq.poll();

            if(curr[0] == 0 || curr[0] == R-1 || curr[1] == 0 || curr[1] == C-1) {
                System.out.println(jDist[curr[0]][curr[1]]+1);
                return;
            }

            for(int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if(jDist[nr][nc] != -1 || board[nr][nc] == '#') continue;
                if(fireDist[nr][nc] != -1 && fireDist[nr][nc] <= jDist[curr[0]][curr[1]] + 1) continue;

                jDist[nr][nc] = jDist[curr[0]][curr[1]] + 1;
                jq.add(new int[] {nr, nc});
            }
        }

        System.out.println("IMPOSSIBLE");

    }

}

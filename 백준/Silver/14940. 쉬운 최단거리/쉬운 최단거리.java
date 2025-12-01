import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int[][] dist = new int[N][M];

        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                    r = i;
                    c = j;
                }else if(board[i][j] == 0){
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = -1;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[r][c] = true;
        queue.add(new int[] {r, c, 0});

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            dist[curr[0]][curr[1]] = curr[2];

            for(int d=0 ; d < 4; d++){
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && board[nr][nc] != 0){
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, curr[2]+1});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
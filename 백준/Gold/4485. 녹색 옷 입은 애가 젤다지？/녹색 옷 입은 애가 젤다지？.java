import java.io.*;
import java.util.*;

class Main {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 0;

        while(true){
            int N = Integer.parseInt(br.readLine());
            T++;

            if(N == 0) break;

            int[][] board = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
            pq.offer(new int[]{0, 0, board[0][0]});

            int[][] min = new int[N][N];
            for(int i = 0; i < N; i++){
                Arrays.fill(min[i], Integer.MAX_VALUE);
            }
            min[0][0] = board[0][0];

            while(!pq.isEmpty()){
                int[] cur = pq.poll();

                if(cur[2] > min[cur[0]][cur[1]]) continue;

                if(cur[0] == N-1 && cur[1] == N-1){
                    break;
                }

                for(int d=0 ; d < 4; d++){
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                        int cost = cur[2] + board[nr][nc];

                        if(cost >= min[nr][nc]) continue;

                        pq.offer(new int[]{nr, nc, cost});
                        min[nr][nc] = cost;
                    }
                }
            }

            sb.append("Problem ").append(T).append(": ").append(min[N-1][N-1]).append('\n');
        }

        System.out.println(sb);
    }

}

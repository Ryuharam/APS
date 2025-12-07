import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == 1) cnt++;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int time = 0;
        while(cnt > 0){
            time++;
            boolean[][] visited = new boolean[N][M];
            int[][] touch = new int[N][M];

            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[] {0,0});

            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                for(int d=0 ; d<4; d++){
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]){
                        if(room[nr][nc] == 1 && touch[nr][nc] == 0) {
                            touch[nr][nc] = 1;
                        }else if(room[nr][nc] == 1 && touch[nr][nc] == 1){
                            cnt--;
                            room[nr][nc] = 0;
                            visited[nr][nc] = true;
                        }else{
                            queue.add(new int[] {nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }

        }

        System.out.println(time);

    }
}
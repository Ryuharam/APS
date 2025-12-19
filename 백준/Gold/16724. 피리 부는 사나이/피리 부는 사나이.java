import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // U, L, D, R
    static final int[] dr = {-1,0,1,0};
    static final int[] dc = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if(c == 'U') grid[i][j] = 0;
                else if(c == 'L') grid[i][j] = 1;
                else if(c == 'D') grid[i][j] = 2;
                else grid[i][j] = 3;
            }
        }

        int cnt = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) continue;
                visited[i][j] = true;
                cnt++;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    
                    int nr = cur[0] + dr[grid[cur[0]][cur[1]]];
                    int nc = cur[1] + dc[grid[cur[0]][cur[1]]];
                    
                    if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                    
                    for(int d = 0; d < 4; d++) {
                        nr = cur[0] + dr[d];
                        nc = cur[1] + dc[d];
                        
                        if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                        
                        if(cur[0] == nr + dr[grid[nr][nc]] && cur[1] == nc + dc[grid[nr][nc]]) {
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MOD = 10;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0 || visited[i][j]) continue;

                visited[i][j] = true;

                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                int cnt = 0;
                HashSet<Integer> set = new HashSet<>();

                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    cnt++;

                    for(int d = 0; d < 4; d++){
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;

                        if(map[nr][nc] != 0) {
                            set.add(nr*1000 + nc);
                            continue;
                        }

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                for (int n : set) {
                    int r = n / 1000;
                    int c = n % 1000;

                    map[r][c] += cnt;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(map[i][j] % 10);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());

    }
}
import java.io.*;
import java.util.*;

public class Main {

    static int N, size, x, y;
    static int[][] room;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N][N];
        size = 2;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == 9){
                    x = i;
                    y = j;
                    room[i][j] = 0;
                }
            }
        }

        int time = 0;
        int eaten = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]){
                    if(o1[0] == o2[0]){
                        return o1[1] - o2[1];
                    }else{
                        return o1[0] - o2[0];
                    }
                }else{
                    return o1[2] - o2[2];
                }
            }
        });

        while (true){
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            q.add(new int[]{x,y,0});
            visited[x][y] = true;
            while (!q.isEmpty()){
                int[] cur = q.poll();

                if(room[cur[0]][cur[1]] > 0 && room[cur[0]][cur[1]] < size){
                    pq.add(new int[]{cur[0], cur[1], cur[2]});
                }

                for(int d=0 ; d<4; d++){
                    int nx = cur[0] + dr[d];
                    int ny = cur[1] + dc[d];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < N
                            && !visited[nx][ny] && room[nx][ny] <= size){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny,cur[2]+1});
                    }
                }
            }

            if(pq.isEmpty()) break;

            int[] fish = pq.poll();
            room[fish[0]][fish[1]] = 0;
            eaten++;
            if(eaten == size){
                size++;
                eaten = 0;
            }
            room[fish[0]][fish[1]] = 0;
            x = fish[0];
            y = fish[1];
            pq.clear();

            time += fish[2];
        }

        System.out.println(time);

    }

}
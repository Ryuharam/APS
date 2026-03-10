import java.io.*;
import java.util.*;

class Main {

    static int N, L, R;
    static int[][] A;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;

        while(move()) day++;

        System.out.println(day);
    }

    static boolean move(){
        boolean[][] visited = new boolean[N][N];
        int[][] next_A = new int[N][N];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(visited[i][j]) continue;

                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i,j});

                List<int[]> list = new ArrayList<>();

                int sum = 0;
                int cnt = 0;
                visited[i][j] = true;

                while(!stack.isEmpty()){
                    int[] curr = stack.pop();
                    list.add(curr);
                    sum += A[curr[0]][curr[1]];
                    cnt++;

                    for(int d=0 ; d<4 ; d++){
                        int nr = curr[0] + dr[d];
                        int nc = curr[1] + dc[d];

                        if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]
                                && Math.abs(A[curr[0]][curr[1]] - A[nr][nc]) >= L
                                && Math.abs(A[curr[0]][curr[1]] - A[nr][nc]) <= R
                        ){
                            int[] next = new int[]{nr,nc};
                            stack.push(next);
                            visited[nr][nc] = true;
                        }
                    }
                }

                int tmp = sum/cnt;
                for(int[] l : list){
                    next_A[l[0]][l[1]] = tmp;
                }
            }
        }

        boolean flag = false;

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(A[i][j] != next_A[i][j]) {
                    flag = true;
                    A[i][j] = next_A[i][j];
                }
            }
        }

        return flag;
    }

}

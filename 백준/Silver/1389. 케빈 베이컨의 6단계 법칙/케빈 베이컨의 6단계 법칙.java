import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE/2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] adj = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                adj[i][j] = i==j? 0 : INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = 1;
            adj[y][x] = 1;
        }

        for(int m=1 ; m <= N; m++){
            for(int s=1 ; s<= N; s++){
                for(int e=1 ; e<= N; e++){
                    adj[s][e] = Math.min(adj[s][e], adj[s][m] + adj[m][e]);
                }
            }
        }

        int min = INF;
        int person = 1;
        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 1; j <= N; j++){
                sum += adj[i][j];
            }
            if(sum < min){
                min = sum;
                person = i;
            }else if(sum == min){
                person = Math.min(person, i);
            }
        }

        System.out.println(person);

    }

}
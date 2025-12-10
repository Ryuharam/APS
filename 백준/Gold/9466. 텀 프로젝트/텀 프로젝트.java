import java.io.*;
import java.util.*;

public class Main {

    static int N, Cnt;
    static int[] choose;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            choose = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];
            Cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                choose[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++){
                dfs(i);
            }

            int ans = N - Cnt;
            sb.append(ans).append("\n");

        }

        System.out.print(sb);
    }

    static void dfs(int cur){
        if(visited[cur]) return;

        visited[cur] = true;
        int next = choose[cur];

        if(!visited[next]){
            dfs(next);
        }else{
            if(!finished[next]){
                Cnt++;
                for(int i=next ; i !=cur ; i=choose[i]){
                    Cnt++;
                    finished[i] = true;
                    visited[i] = true;
                }
            }
        }

        finished[cur] = true;
    }
}
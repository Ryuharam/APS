import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[][] adj = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                adj[i][j] = x == 0 ? INF : x;
            }
        }

        for(int m = 0; m < N; m++){
            for(int s = 0; s < N; s++){
                for(int e = 0; e < N; e++){
                    adj[s][e] = Math.min(adj[s][e], adj[s][m] + adj[m][e]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(adj[i][j] == INF){
                    sb.append('0');
                }else{
                    sb.append('1');
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
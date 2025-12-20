import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println(0);
            return;
        }

        int[][] procession = new int[N+1][2];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            procession[i][0] = Integer.parseInt(st.nextToken());
            procession[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                dp[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for(int d = 1 ; d < N; d++){
            for(int r = 1 ; r+d <= N; r++){
                int c = r + d;
                for(int m = r ; m < c ; m++){
                    dp[r][c] = Math.min(dp[r][c], dp[r][m] + dp[m+1][c] +
                            procession[r][0]*procession[m][1]*procession[c][1]);
                }
            }
        }

        System.out.println(dp[1][N]);
    }

}
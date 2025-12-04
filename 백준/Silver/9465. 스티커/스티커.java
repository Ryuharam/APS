import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[2][N];
            int[][] dp = new int[2][N];

            for(int i =0 ; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j =0 ; j<N; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];

            if(N==1){
                sb.append(Math.max(dp[0][0], dp[1][0])).append("\n");
                continue;
            }

            dp[0][1] = score[1][0] + score[0][1];
            dp[1][1] = score[1][1] + score[0][0];

            if(N==2){
                sb.append(Math.max(dp[0][1], dp[1][1])).append("\n");
                continue;
            }

            for(int i=2 ; i<N; i++) {
                for(int j=0 ; j<2 ; j++){
                    int r = (j + 1) % 2;
                    dp[j][i] = Math.max(dp[r][i-1],dp[r][i-2]) + score[j][i];
                }
            }

            sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
        }

        System.out.println(sb);
    }

}
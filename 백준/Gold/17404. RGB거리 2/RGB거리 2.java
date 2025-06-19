import java.util.*;
import java.io.*;

public class Main{
    
    public static final int INF = 1000*1000+1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] cost = new int[N+1][3];   

        for(int i=1 ; i<=N ; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
            
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        
        int answer = INF;
        
        for(int i=0 ; i<3 ; i++){
            int[][] dp = new int[N+1][3];
            
            for(int j=0 ; j<3 ; j++){
                if(i==j) dp[1][j] = cost[1][j];
                else dp[1][j] = INF;
            }
            
            for(int j=2 ; j<=N ; j++){
                dp[j][0] = Math.min(dp[j-1][1],dp[j-1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j-1][0],dp[j-1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j-1][0],dp[j-1][1]) + cost[j][2];
            }
            
            for(int j=0 ; j<3 ; j++){
                if(i==j) continue;
                answer = Math.min(answer, dp[N][j]);
            }
            
        }
        
        System.out.println(answer);
        
    }
}
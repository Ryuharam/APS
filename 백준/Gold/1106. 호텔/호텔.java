import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[c+101];
        Arrays.fill(dp, Integer.MAX_VALUE-100);
        
        dp[0] = 0;
        
        for(int i=0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            for(int j=p ; j<=c+100 ; j++){
                dp[j] = Math.min(dp[j],dp[j-p]+m);
            }
        }
        
        int answer = dp[c];
        
        for(int i=c+1 ; i<=c+100 ; i++){
            answer = Math.min(answer, dp[i]);
        }
        
        System.out.println(answer);
	}
}
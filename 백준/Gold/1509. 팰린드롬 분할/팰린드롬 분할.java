import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        int N = string.length();
        int[] dp = new int[N+1];
        Arrays.fill(dp, 2500);
        dp[0] = 0;

        for(int i=1 ; i<=N ; i++){
            dp[i] = dp[i-1] + 1;
            for(int j=i-1 ; j>0 ; j--){
                if(isPalin(j-1,i-1,string)){
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }
        
        System.out.println(dp[N]);

    }

    static boolean isPalin(int s, int e, String line){
        while(s<e){
            if(line.charAt(s) != line.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }

}
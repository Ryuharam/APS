import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        int max = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;

            for(int j = i-1 ; j>=0 ; j--) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);

    }
}

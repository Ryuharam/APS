import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while(true){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 0) break;
            list.add(tmp);
        }

        int size = list.size();
        int[][][] dp = new int[5][5][size+1];
        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<5 ; j++){
                for(int k=0 ; k<=size ;k++){
                    dp[i][j][k] = 400_000;
                }
            }
        }

        dp[0][0][0] = 0;
        int time = 1;
        for(int next : list){
            for(int i=0 ; i<5 ; i++){
                for(int j=0 ; j<5 ; j++){
                    dp[next][j][time] = Math.min(dp[next][j][time], dp[i][j][time-1]+getMove(next, i));
                    dp[i][next][time] = Math.min(dp[i][next][time], dp[i][j][time-1]+getMove(next, j));
                }
            }
            time++;
        }
        int ans = 400_000;
        int last = list.get(size-1);

        for(int i=0 ; i<5 ; i++){
            ans = Math.min(ans, dp[last][i][time-1]);
            ans = Math.min(ans, dp[i][last][time-1]);
        }
        System.out.println(ans);
    }

    static int getMove(int n, int c){
        if(c == 0){
            return 2;
        }else if(n == c){
            return 1;
        }else if(( n + c ) % 2 == 0){
            return 4;
        }else{
            return 3;
        }
    }

}
import java.io.*;
import java.util.*;

class Main {

    static int N;
    static String end;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String start = br.readLine();
        end = br.readLine();

        int res1 = solve(start.toCharArray(), false);
        int res2 = solve(start.toCharArray(), true);

        int ans = Math.min(res1, res2);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    static int solve(char[] arr, boolean pushFirst){
        int cnt = 0;

        if(pushFirst){
            push(arr, 0);
            cnt++;
        }

        for(int i=1 ; i<N ; i++){
            if(arr[i-1] != end.charAt(i-1)){
                push(arr, i);
                cnt++;
            }
        }

        if(new String(arr).equals(end)){
            return cnt;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    static void push(char[] arr, int idx){
        for(int i = idx-1 ; i <= idx+1 ; i++){
            if(i>=0 && i<N){
                arr[i] = arr[i] == '0' ? '1' : '0';
            }
        }
    }
}

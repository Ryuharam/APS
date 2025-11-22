import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] height = new int[N][M];
        int min = 256;
        int max = 0;
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M ; j++){
                height[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, height[i][j]);
                max = Math.max(max, height[i][j]);
            }
        }
        
        int time = 0;
        int ans = min;
        for(int i=min ; i<=max ; i++){
            int cnt = B;
            int tmp = 0;
            
            for(int r=0 ; r<N ; r++){
                for(int c=0 ; c<M ; c++){
                    if(height[r][c]>i){
                        cnt += (height[r][c] - i);
                        tmp += (height[r][c] - i)*2;
                    }else if(height[r][c]<i){
                        cnt -= (i-height[r][c]);
                        tmp += (i-height[r][c]);
                    }
                }
            }
            if(cnt>=0) {
                if(time==0 || tmp<time){
                    time = tmp;
                    ans = i;
                }else if(tmp==time && ans<i){
                    time = tmp;
                    ans = i;
                }
            }
        }
        System.out.println(time+" "+ans);
    }
}
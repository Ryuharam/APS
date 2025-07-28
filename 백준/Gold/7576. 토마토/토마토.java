import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] boxes = new int[N][M];
        int cnt = 0;
        
        Deque<int[]> dq = new LinkedList<>();
        
        for(int n=0 ; n<N ; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0 ; m<M ; m++){
                boxes[n][m] = Integer.parseInt(st.nextToken());
                if(boxes[n][m]==0){
                    cnt++;
                }
                else if(boxes[n][m]==1){
                    dq.add(new int[]{n,m});
                }
            }
        }
        
        if(cnt==0){
            System.out.println(0);
            return;
        }
        
        int[] dn = {1,0,-1,0};
        int[] dm = {0,1,0,-1};
        int day = 0;
        
        while(!dq.isEmpty() && cnt>0){
            int tmp = dq.size();
            day++;
            
            for(int i=0 ; i<tmp ; i++){
                int[] curr = dq.pollFirst();
                
                for(int d=0 ; d<4 ; d++){
                    int n = curr[0] + dn[d];
                    int m = curr[1] + dm[d];
                    
                    if(0<=n && n<N && 0<=m && m<M
                      && boxes[n][m]==0){
                        boxes[n][m] = 1;
                        cnt--;
                        dq.addLast(new int[]{n,m});
                    }
                }
            }
        }
        
        if(cnt>0){
            System.out.println(-1);
            return;
        }
        System.out.println(day);
        
    }
}
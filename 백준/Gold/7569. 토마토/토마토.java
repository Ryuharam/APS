import java.io.*;
import java.util.*;

public class Main {
    
    static int M, N, H;
    static int[][][] boxes;
    
    static int[] dh = {1,0,0,-1,0,0};
    static int[] dn = {0,1,0,0,-1,0};
    static int[] dm = {0,0,1,0,0,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        boxes = new int[H][N][M];
        Deque<int[]> dq = new LinkedList<>();
        int notRipen = 0;
        
        for(int h=0 ; h<H ; h++){
            for(int n=0 ; n<N ; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0 ; m<M ; m++){
                    boxes[h][n][m] = Integer.parseInt(st.nextToken());
                    if(boxes[h][n][m]==1){
                        dq.add(new int[]{h,n,m});
                    }
                    else if(boxes[h][n][m]==0){
                        notRipen++;
                    }
                }
            }
        }
        
        if(notRipen==0){
            System.out.println(0);
            return;
        }
        
        int day = 0;
        
        while(!dq.isEmpty() && notRipen!=0){
            int cnt = dq.size();
            day++;
            
            for(int i=0 ; i<cnt ; i++){
                int[] curr = dq.pollFirst();
                
                int h = curr[0];
                int n = curr[1];
                int m = curr[2];
                
                for(int d=0 ; d<6 ; d++){
                    int nh = curr[0]+dh[d];
                    int nn = curr[1]+dn[d];
                    int nm = curr[2]+dm[d];
                    
                    if(0<=nh && nh<H && 0<=nn && nn<N && 0<=nm && nm<M
                      && boxes[nh][nn][nm] == 0){
                        boxes[nh][nn][nm] = 1;
                        dq.addLast(new int[]{nh,nn,nm});
                        notRipen--;
                    }
                }
            }
        }
        
        if(notRipen>0){
            System.out.println(-1);
        }else{
            System.out.println(day);
        }


    }
    
}
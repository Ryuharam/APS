import java.io.*;
import java.util.*;

public class Main{
    
    static final int INF = 100_000_000;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());
        
        for(int tc=0 ; tc<TC ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 지점의 수 1<=n<=500
            int n = Integer.parseInt(st.nextToken());
            // 도로의 개수 1<=m<=2500
            int m = Integer.parseInt(st.nextToken());
            // 웜홀의 개수 1<=w<=200
            int w = Integer.parseInt(st.nextToken());
            
            // 시작 지점
            int[] start = new int[2*m+w];
            int[] end = new int[2*m+w];
            int[] time = new int[2*m+w];
            int idx = 0;
            
            for(int i=0 ; i<m+w ; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;
                int t = Integer.parseInt(st.nextToken());
                if(i<m){
                    start[idx] = e;
                    end[idx] = s;
                    time[idx] = t;
                    idx++;
                }else{
                    t = -t;
                }
                start[idx] = s;
                end[idx] = e;
                time[idx] = t;
                idx++;
            }
            
            
            int[] dist = new int[n];
            boolean flag = false;
            
            for(int i=0 ; i<n; i++){
                flag = false;
                for(int j=0 ; j<2*m+w ; j++){
                    if(dist[end[j]]>dist[start[j]]+time[j]){
                        dist[end[j]] = dist[start[j]]+time[j];
                        flag = true;
                    }
                }
                if(!flag) break;
            }

            sb.append(flag?"YES":"NO").append("\n");
        }    
        System.out.println(sb);
        
    }
}
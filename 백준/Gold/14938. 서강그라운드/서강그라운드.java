import java.io.*;
import java.util.*;

public class Main{
    
    static final int INF = 15000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 지역 개수 1<=n<=100
        int n = Integer.parseInt(st.nextToken());
        // 수색 범위 1<=m<=15
        int m = Integer.parseInt(st.nextToken());
        // 길의 개수 1<=r<=100
        int r = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        // 아이템의 수 1<=t<=15
        int[] items = new int[n];
        for(int i=0 ; i<n ; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dist = new int[n][n];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                dist[i][j] = i==j? 0 : INF;
            }
        }
        
        for(int i=0 ; i<r ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int l = Integer.parseInt(st.nextToken());
            dist[a][b] = l;
            dist[b][a] = l;
        }
        
        for(int k=0 ; k<n ; k++){
            for(int i=0 ; i<n ; i++){
                for(int j=0 ; j<n ; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        int max = 0;
        for(int i=0 ; i<n ; i++){
            int sum = 0;
            for(int j=0 ; j<n ; j++){
                sum += dist[i][j]<=m? items[j] : 0;
            }
            max = Math.max(max, sum);
        }
        
        System.out.println(max);
    }
}
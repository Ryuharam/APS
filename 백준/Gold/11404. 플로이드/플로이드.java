import java.io.*;
import java.util.*;

public class Main{
    
    static int INF = Integer.MAX_VALUE;
    static List<Long>[] adj;
    static int[][] dist;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0 ; i<M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long tmp = ((long)b<<32) | (c&0xFFFFFFFFL);
            adj[a].add(tmp);
        }
        
        dist = new int[N+1][N+1];
        
        for(int i=1 ; i<=N ; i++){
            getCost(i, N);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                sb.append(dist[i][j]==INF?0:dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void getCost(int start, int N){
        Arrays.fill(dist[start], INF);
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(0<<32 | start&0xFFFFFFFFL);
        dist[start][start] = 0;
        
        while(!pq.isEmpty()){
            long curr = pq.poll();
            int cost = (int)(curr>>>32);
            int node = (int)(curr&0xFFFFFFFFL);
            
            if(dist[start][node]!=cost) continue;
            
            for(long next : adj[node]){
                int n = (int)(next>>>32);
                int c = (int)(next&0xFFFFFFFFL);
                int nc = cost + c;
                
                if(nc<dist[start][n]){
                    dist[start][n] = nc;
                    pq.add(((long)nc<<32) | (n&0xFFFFFFFFL));
                }
            }
        }
    }
}
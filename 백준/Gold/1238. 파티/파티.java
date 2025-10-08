import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        ArrayList<Long>[] adj = new ArrayList[N+1];
        ArrayList<Long>[] rev = new ArrayList[N+1];
        
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }
        
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            long packed = ((long) b<<32)|(w&0xFFFFFFFFL);
            adj[a].add(packed);
            
            long revPacked = ((long) a<<32)|(w&0xFFFFFFL);
            rev[b].add(revPacked);
        }
        
        int[] go = dijkstra(rev, X, N);
        int[] come = dijkstra(adj, X, N);
        
        int ans = 0;
        for(int i=1 ; i<=N ; i++){
            ans = Math.max(ans, go[i]+come[i]);
        }
        
        System.out.println(ans);

    }
    
    static int[] dijkstra(ArrayList<Long>[] graph, int start, int N){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(((long)dist[start]<<32)|(start&0xFFFFFFFFL));
        
        while(!pq.isEmpty()){
            long curr = pq.poll();
            int node = (int)(curr&0xFFFFFFFFL);
            int d = (int)(curr>>>32);
            
            if(d!=dist[node]) continue;
            
            for(long e : graph[node]){
                int to = (int)(e>>>32);
                int w = (int)(e&0xFFFFFFFFL);
                
                int nd = d+w;
                if(nd < dist[to]){
                    dist[to] = nd;
                    pq.add(((long)nd<<32)|(to&0xFFFFFFFFL));
                }
            }
        }
        
        return dist;
    }
}
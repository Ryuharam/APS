import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Long>[] adj;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N+1];
        
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0 ; i<E ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adj[a].add(((long)b<<32) | (c&0xFFFFFFFFL));
            adj[b].add(((long)a<<32) | (c&0xFFFFFFFFL));
        }
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int AtoV1 = getDist(1, v1);
        int AtoV2 = getDist(1, v2);
        int V1toV2 = getDist(v1, v2);
        int V1toN = getDist(v1, N);
        int V2toN = getDist(v2, N);
        
        long path1 = validSum(AtoV1, V1toV2, V2toN);
        long path2 = validSum(AtoV2, V1toV2, V1toN);
        
        long best = Math.min(path1, path2);
        
        if(best == Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(best);
        }
        
    }
    
    static int getDist(int start, int end){
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(((long)0<<32) | (start&0xFFFFFFFFL));
        
        while(!pq.isEmpty()){
            long curr = pq.poll();
            int c = (int)(curr&0xFFFFFFFFL);
            int d = (int)(curr>>>32);
            
            if(c==end) break;
            
            if(d!=dist[c]) continue;
            
            for(long e : adj[c]){
                int n = (int)(e>>>32);
                int w = (int)(e&0xFFFFFFFFL);
                
                int nw = d+w;
                if(nw<dist[n]){
                    dist[n] = nw;
                    pq.add(((long)nw<<32) | (n&0xFFFFFFFFL));
                }
            }
        }
        
        return dist[end];
    }
    
    static long validSum(int a, int b, int c){
        if(a==INF || b==INF || c==INF) return Long.MAX_VALUE;
        return(long) a+b+c;
    }
}
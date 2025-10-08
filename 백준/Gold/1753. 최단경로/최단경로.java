import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        ArrayList<int[]>[] links = new ArrayList[V+1];
        
        for(int i=1 ; i<=V ; i++){
            links[i] = new ArrayList<>();
        }
        
        for(int i=0 ; i<E ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            links[u].add(new int[]{v,w});
        }
        
        int[] dist = new int[V+1];
        Arrays.fill(dist,-1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        pq.add(new int[]{K,0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            if(dist[curr[0]]!=-1) continue;
            
            dist[curr[0]] = curr[1];
            
            for(int[] next : links[curr[0]]){
                pq.add(new int[]{next[0],curr[1]+next[1]});
            }
        }
        
        for(int i=1 ; i<=V ; i++){
            if(dist[i]==-1){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
        
    }
}
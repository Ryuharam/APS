import java.io.*;
import java.util.*;

public class Main{
    
    static final int MAX = 100000;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if(N==K){
            System.out.println(0+"\n"+1);
            return;
        }
        
        int[] dist = new int[MAX+1];
        Arrays.fill(dist, -1);
        int[] ways = new int[MAX+1];
        
        Queue<Integer> queue = new LinkedList<>();
        
        dist[N]=0;
        ways[N]=1;
        queue.add(N);
        
        while(!queue.isEmpty()){
            int c = queue.poll();
            int nd = dist[c] + 1;
            
            if(dist[K]!=-1 && nd>dist[K]) continue;
            
            if(c-1>=0){
                int v = c-1;
                if(dist[v]==-1){
                    dist[v] = nd;
                    ways[v] = ways[c];
                    queue.add(v);
                }else if(dist[v]==nd){
                    ways[v] += ways[c];
                }
            }
            
            if(c+1<=MAX){
                int v = c+1;
                if(dist[v]==-1){
                    dist[v] = nd;
                    ways[v] = ways[c];
                    queue.add(v);
                }else if(dist[v]==nd){
                    ways[v] += ways[c];
                }
            }
            
            if(c*2<=MAX){
                int v = c*2;
                if(dist[v]==-1){
                    dist[v] = nd;
                    ways[v] = ways[c];
                    queue.add(v);
                }else if(dist[v]==nd){
                    ways[v] += ways[c];
                }
            }
        }
        
        System.out.println(dist[K]+"\n"+ways[K]);
 
    }
}
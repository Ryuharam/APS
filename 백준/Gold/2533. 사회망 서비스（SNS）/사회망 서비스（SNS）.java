import java.util.*;
import java.io.*;

public class Main {
    
    static List<Integer>[] link;
    static boolean[] visited;
    static int[][] dp;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        link = new ArrayList[N+1];
        visited = new boolean[N+1];
        dp = new int[N+1][2];
        
        for(int i=1 ; i<=N ; i++){
            link[i] = new ArrayList<>();
        }
        
        for(int i=0 ; i<N-1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            link[u].add(v);
            link[v].add(u);
        }
        
        rf(1);
        
        System.out.println(Math.min(dp[1][0],dp[1][1]));
        
	}
    
    static void rf(int root){
        visited[root] = true;
        dp[root][0] = 1;
        
        for(int child : link[root]){
            if(visited[child]) continue;
            rf(child);
            dp[root][0] += Math.min(dp[child][0], dp[child][1]);
            dp[root][1] += dp[child][0];
        }
    }
}
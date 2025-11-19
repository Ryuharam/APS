import java.io.*;
import java.util.*;

public class Main {
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1 ; i<=N ; i++){
            parent[i] = i;
        }
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        for(int i=1 ; i<=N ; i++){
            if(i==parent[i]) cnt++;
        }
        System.out.println(cnt);
    }
    static void union(int a, int b){
        if(parent[a]==parent[b]) return;
        
        int p1 = find(a);
        int p2 = find(b);
        if(p1<=p2){
            parent[p2] = p1;
        }else{
            parent[p1] = p2;
        }
    }
    
    static int find(int a){
        if(parent[a]==a) return a;
        
        return parent[a] = find(parent[a]);
    }
}
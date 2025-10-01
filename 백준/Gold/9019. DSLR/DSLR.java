import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        
        int MOD = 10000;

        for(int t=0 ; t<tc ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            boolean[] visited = new boolean[MOD];
            int[] parent = new int[MOD];
            char[] oper = new char[MOD];
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(A);
            visited[A] = true;
            parent[A] = -1;
            
            while(!queue.isEmpty() && !visited[B]){
                int curr = queue.poll();
                
                int d = (curr*2)%MOD;
                if(!visited[d]){
                    queue.add(d);
                    visited[d] = true;
                    parent[d] = curr;
                    oper[d] = 'D';
                }
                
                int s = (curr+MOD-1)%MOD;
                if(!visited[s]){
                    queue.add(s);
                    visited[s] = true;
                    parent[s] = curr;
                    oper[s] = 'S';
                }
                
                int l = (curr*10+curr/1000)%MOD;
                if(!visited[l]){
                    queue.add(l);
                    visited[l] = true;
                    parent[l] = curr;
                    oper[l] = 'L';
                }
                
                int r = (curr%10)*1000 + curr/10;
                if(!visited[r]){
                    queue.add(r);
                    visited[r] = true;
                    parent[r] = curr;
                    oper[r] = 'R';
                }
            }
            
            StringBuilder tmp = new StringBuilder();
            int c = B;
            while(parent[c]!=-1){
                tmp.append(oper[c]);
                c = parent[c];
            }
            
            sb.append(tmp.reverse()).append("\n");

        }
        System.out.println(sb);
    }
}

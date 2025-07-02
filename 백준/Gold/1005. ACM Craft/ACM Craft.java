import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());
        
        for(int t=0 ; t<TC ; t++){
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            List<Integer>[] link = new List[N+1];
            Queue<Integer> queue = new LinkedList<>();
            int[] degree = new int[N+1];
            
            int[] D = new int[N+1];
            st = new StringTokenizer(br.readLine());
            
            for(int i=1 ; i<=N ; i++){
                D[i] = Integer.parseInt(st.nextToken());
                link[i] = new ArrayList<>();
            }
            
            for(int i=0 ; i<K ; i++){
                st = new StringTokenizer(br.readLine());
                
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                
                link[X].add(Y);
                degree[Y]++;
                
            }
            
            int W = Integer.parseInt(br.readLine());
            int[] result = new int[N+1];
            
            for(int i=1 ; i<=N ; i++){
                result[i] = D[i];
                
                if(degree[i]==0){
                    queue.add(i);
                }
            }
            
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                
                for(int i : link[tmp]){
                    degree[i]--;
                    result[i] = Math.max(result[i], result[tmp] + D[i]);
                    
                    if(degree[i] == 0){
                        queue.add(i);
                    }
                }
                
            }
            
            System.out.println(result[W]);
        }
	}
}
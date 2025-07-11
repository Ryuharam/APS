import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] link = new ArrayList[N+1];
        Set<Integer> p = new HashSet<>();
        int[] inter = new int[N+1];
        
        for(int i=1 ; i<=N ; i++){
            link[i] = new ArrayList<>();
            p.add(i);
        }
        
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            
            for(int j=1 ; j<tmp ; j++){
                int next = Integer.parseInt(st.nextToken());
                inter[next]++;
                link[prev].add(next);
                prev = next;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=1 ; i<=N ; i++){
            if(inter[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            p.remove(curr);
            sb.append(curr).append("\n");
            
            for(int next : link[curr]){
                inter[next]--;
                
                if(inter[next]==0){
                    queue.add(next);
                }
            }
        }
        
        if(!p.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(sb);
        }
        
        
		
	}
}
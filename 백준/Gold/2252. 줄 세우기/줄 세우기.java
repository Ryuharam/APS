import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] degrees = new int[N+1];
        List<Integer>[] link = new ArrayList[N+1];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1 ; i<=N ; i++){
            link[i] = new ArrayList<>();
        }
        
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            degrees[b]++;
            link[a].add(b);
        }
        
        for(int i=1 ; i<=N ; i++){
            if(degrees[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            sb.append(tmp).append(" ");
            
            for(int i : link[tmp]){
                degrees[i]--;
                
                if(degrees[i] == 0){
                    queue.add(i);
                }
            }
        }
        
        System.out.println(sb);
	}
}
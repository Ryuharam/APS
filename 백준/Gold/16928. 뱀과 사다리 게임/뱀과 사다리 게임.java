import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] move = new int[101];
        
        for(int i=1 ; i<101 ; i++){
            move[i] = i;
        }
        
        for(int i=0 ; i<N+M ; i++){
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        
        int[] count = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        
        while(true){
            int curr = queue.poll();
            
            for(int i=1 ; i<=6 ; i++){
                int next = curr+i;
                
                if(next>100) break;
                
                if(count[move[next]]==0){
                    count[move[next]] = count[curr]+1;
                    queue.add(move[next]);
                }
                
                if(move[next]==100){
                    System.out.println(count[move[next]]);
                    return;
                }
                
            }
        }
    }
}
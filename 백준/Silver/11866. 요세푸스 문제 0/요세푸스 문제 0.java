import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1 ; i<=N ; i++){
            queue.add(i);
        }
        
        sb.append("<");
        for(int i=1; i<K ; i++){
            queue.add(queue.poll());
        }
        sb.append(queue.poll());
        while(!queue.isEmpty()){
            sb.append(", ");
            for(int i=1 ; i<K ; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
        }
        sb.append(">");
        
        System.out.println(sb);
    }
}
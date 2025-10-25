import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=1 ; i<=N ; i++){
            queue.add(i);
        }
        
        while(queue.size()>1){
            queue.poll();
            int tmp = queue.poll();
            queue.add(tmp);
        }
        
        System.out.println(queue.poll());
    }
}
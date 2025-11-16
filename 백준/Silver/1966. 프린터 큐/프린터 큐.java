import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());
        for(int tc=0 ; tc<TC ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] priority = new int[N];
            Queue<Integer> queue = new ArrayDeque<>();
            PriorityQueue<Integer> priorities = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<N ; i++){
                queue.add(i);
                priority[i] = 10-Integer.parseInt(st.nextToken());
                priorities.add(priority[i]);
            }
            int cnt=0;
            while(true){
                int curr = queue.peek();
                int p = priorities.peek();
                if(priority[curr]==p){
                    cnt++;
                    if(curr==M){
                        sb.append(cnt+"\n");
                        break;
                    }else{
                        queue.poll();
                        priorities.poll();
                    }
                }else{
                    queue.add(queue.poll());
                }
            }
        }
        
        System.out.println(sb);
    }
}
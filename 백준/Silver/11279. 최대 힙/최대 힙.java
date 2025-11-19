import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0 ; i<N ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                sb.append(pq.isEmpty()? 0 : pq.poll()).append("\n");
            }else{
                pq.add(num);
            }
        }
        System.out.println(sb);
    }
}
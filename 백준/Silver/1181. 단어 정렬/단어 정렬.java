import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<String> pq = new PriorityQueue<>(
        new Comparator<String>() {
            public int compare(String o1, String o2){
                if(o1.length() > o2.length()){
                    return 1;
                }
                else if(o1.length() < o2.length()){
                    return -1;
                }
                else{
                    return o1.compareTo(o2);
                }
            }
        });
        
        for(int i=0 ; i<N ; i++){
            String str = br.readLine();
            
            if(pq.contains(str)) continue;
            pq.add(str);
        }
        
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
	}
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(br.readLine());
        
        for(int t=0 ; t<tc ; t++){
            int k = Integer.parseInt(br.readLine());
            
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int i=0 ; i<k ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                String oper = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                
                if("I".equals(oper)){
                    max.add(num);
                    min.add(num);
                    map.put(num, map.getOrDefault(num,0)+1);
                }else{
                    if(map.size()==0) continue;
                    
                    if(num==1){
                        delete(max, map);
                    }else{
                        delete(min, map);
                    }
                }
            } // k
            
            if(map.size()==0){
                sb.append("EMPTY");
            }else{
                int tmp = delete(max, map);
                sb.append(tmp+" ");
                if(map.size()>0){
                    tmp = delete(min, map);
                }
                sb.append(tmp);
            }
            sb.append("\n");
            
        } // tc
        
        System.out.println(sb);
    }
    
    static int delete(PriorityQueue<Integer> pq, Map<Integer, Integer> map){
        int ans = 0;
        
        while(true){
            ans = pq.poll();
            
            int cnt = map.getOrDefault(ans, 0);
            
            if(cnt==0) continue;
            
            if(cnt==1) map.remove(ans);
            else map.put(ans, cnt-1);
            break;
        }
        
        return ans;
    }
}
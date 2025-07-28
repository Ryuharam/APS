import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=0 ; tc<T ; tc++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            Deque<String> dq = new LinkedList<>();
            boolean isReverse = false;
            
            if(n>0){
                String arrContent = arr.substring(1,arr.length()-1);
                String[] values = arrContent.split(",");
                dq.addAll(Arrays.asList(values));
            }
            
            try{
                for(int i=0 ; i<p.length() ; i++){
                    if('R'== p.charAt(i)){
                        isReverse = !isReverse;
                    }else{
                        if(isReverse){
                            dq.removeLast();
                        }else{
                            dq.removeFirst();
                        }
                        n--;
                    }
                }
                
                Iterator<String> iterator;
                
                if(isReverse){
                    iterator = dq.descendingIterator();
                }else{
                    iterator = dq.iterator();
                }
                
                System.out.print("[");
                
                if(n!=0){
                    StringBuilder sb = new StringBuilder();
                    sb.append(iterator.next());
                    while(iterator.hasNext()){
                        sb.append(",");
                        sb.append(iterator.next());
                    }
                    System.out.print(sb);
                }
                
                System.out.println("]");
                    
            }
            catch(Exception e){
                System.out.println("error");
            }
            
        }
    }
}
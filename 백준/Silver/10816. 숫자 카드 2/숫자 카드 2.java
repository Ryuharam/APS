import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            int n = Integer.parseInt(st.nextToken());
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n, 1);
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<M ; i++){
            int n = Integer.parseInt(st.nextToken());
            if(map.containsKey(n)){
                sb.append(map.get(n)+" ");
            }else{
                sb.append(0+" ");
            }
        }
        
        System.out.println(sb);
    }
}
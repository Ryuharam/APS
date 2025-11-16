import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=0 ; tc<TC ; tc++){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int i=0 ; i<N ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0)+1);
            }
            
            int sum = 1;
            for(int cnt : map.values()){
                sum *= (cnt+1);
            }
            sum -= 1;
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1<=K<=100_000
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0 ; i<K ; i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                stack.pop();
                continue;
            }
            stack.push(n);
        }
        
        int sum = 0;
        
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        
        System.out.println(sum);
    }
}
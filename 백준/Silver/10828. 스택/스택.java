import java.io.*;
import java.util.*;

class Stack {
    int top, size;
    int[] nums;
    
    Stack(){
        this.top = 1;
        this.size = 0;
        nums = new int[10002];
        nums[0] = -1;
    }
    
    void push(int n){
        nums[top] = n;
        top++;
        size++;
    }
    
    int pop(){
       if(size==0) return -1;
        top--;
        size--;
        return nums[top];
    }
    
    int size(){
        return size;
    }
    
    int empty(){
        return size==0?1:0;
    }
    
    int top(){
        return nums[top-1];
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 1<=N<=10_000
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        
        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            
            if("push".equals(oper)){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            
            if("pop".equals(oper)){
                sb.append(stack.pop()).append("\n");
            }
            
            if("size".equals(oper)){
                sb.append(stack.size()).append("\n");
            }
            
            if("empty".equals(oper)){
                sb.append(stack.empty()).append("\n");
            }
            
            if("top".equals(oper)){
                sb.append(stack.top()).append("\n");
            }
            
        }
        
        System.out.println(sb);
    }
}
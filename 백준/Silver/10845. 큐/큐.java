import java.io.*;
import java.util.*;

class Queue{
    int front, back, size;
    int[] nums;
    
    Queue(){
        this.front = 10000;
        this.back = 10000;
        this.size = 0;
        nums = new int[10001];
    }
    
    void push(int n){
        nums[back] = n;
        back--;
        size++;
    }
    
    int pop(){
        if(size==0) return -1;
        size--;
        return nums[front--];
    }
    
    int size(){
        return size;
    }
    
    int empty(){
        return size==0? 1:0;
    }
    
    int front(){
        return size==0? -1:nums[front];
    }
    
    int back(){
        return size==0? -1:nums[back+1];
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            
            if("push".equals(oper)){
                int num = Integer.parseInt(st.nextToken());
                queue.push(num);
            }
            
            if("pop".equals(oper)){
                sb.append(queue.pop()).append("\n");
            }
            
            if("size".equals(oper)){
                sb.append(queue.size()).append("\n");
            }
            
            if("empty".equals(oper)){
                sb.append(queue.empty()).append("\n");
            }
            
            if("front".equals(oper)){
                sb.append(queue.front()).append("\n");
            }
            
            if("back".equals(oper)){
                sb.append(queue.back()).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}
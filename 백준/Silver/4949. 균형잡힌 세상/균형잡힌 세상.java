import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    while(true){
        String line = br.readLine();
        if(".".equals(line)) break;
        StringTokenizer st = new StringTokenizer(line);
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        
        while(st.hasMoreTokens()){
            String word = st.nextToken();
            for(int i=0 ; i<word.length() ; i++){
                char c = word.charAt(i);
                
                if('('==c || '['==c){
                    stack.push(c);
                }
                if(')'==c){
                    if(stack.isEmpty() || '('!=stack.peek()){
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
                if(']'==c){
                    if(stack.isEmpty() || '['!=stack.peek()){
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
        }
        
        if(!stack.isEmpty()) flag = false;
        
        sb.append(flag?"yes":"no").append("\n");
        
    }
    
    System.out.println(sb);
    }

    
}
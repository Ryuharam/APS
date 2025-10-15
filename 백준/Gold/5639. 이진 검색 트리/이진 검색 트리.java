import java.util.*;
import java.io.*;

public class Main{
    
    static List<Integer> preorder;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        preorder = new ArrayList<>();
        
        while(true){
            String tmp = br.readLine();
            if(tmp == null) break;
            preorder.add(Integer.parseInt(tmp));
        }
        
        int end = preorder.size();
        
        postorder(0, end-1);
        
    }
    
    static void postorder(int start, int end){
        if(start > end) return;
        
        if(start == end){
            System.out.println(preorder.get(start));
            return;
        }
        
        int curr = preorder.get(start);
        int left = start+1;
        int right = left;
        
        for(int i=left ; i<=end ; i++){
            if(curr<preorder.get(i)) break;
            right++;
        }
        
        postorder(left, right-1);
        postorder(right, end);
        System.out.println(curr);
        
    }
}
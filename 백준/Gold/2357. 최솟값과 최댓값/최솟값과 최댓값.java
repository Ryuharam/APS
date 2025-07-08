import java.util.*;
import java.io.*;

class SegmentTree{
    Long[] minTree;
    Long[] maxTree;
    
    public SegmentTree(int N){
        int h = (int)Math.ceil(Math.log(N)/Math.log(2));
        int treeSize = (int)Math.pow(2, h+1);
        
        minTree = new Long[treeSize];
        maxTree = new Long[treeSize];
    }
    
    public Long minInit(Long[] arr, int node, int start, int end){
        if(start == end){
            return minTree[node] = arr[start];
        }
        
        return minTree[node] = 
            Math.min(minInit(arr, node*2, start, (start+end)/2)
                    , minInit(arr, node*2+1, (start+end)/2+1, end));
    }
    
    public Long maxInit(Long[] arr, int node, int start, int end){
        if(start == end){
            return maxTree[node] = arr[start];
        }
        
        return maxTree[node] = 
            Math.max(maxInit(arr, node*2, start, (start+end)/2)
                    , maxInit(arr, node*2+1, (start+end)/2+1, end));
    }
    
    public Long getMin(int node, int a, int b, int start, int end){
        if(b<start || end<a) return 1000000000L;
        
        if(a<=start && end<=b) return minTree[node];
        
        return Math.min(
        getMin(node*2, a, b, start, (start+end)/2),
        getMin(node*2+1, a, b, (start+end)/2+1, end)
        );
    };
    
    public Long getMax(int node, int a, int b, int start, int end){
        if(end<a || b<start) return 0L;
        
        if(a<=start && end<=b) return maxTree[node];
        
        return Math.max(
        getMax(node*2, a, b, start, (start+end)/2),
        getMax(node*2+1, a, b, (start+end)/2+1, end)
        );
    }
}

public class Main {
	public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Long[] arr = new Long[N+1];
        
        for(int i=1 ; i<=N ; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        
        SegmentTree tree = new SegmentTree(N);
        tree.minInit(arr, 1, 1, N);
        tree.maxInit(arr, 1, 1, N);
        
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            System.out.println(
                tree.getMin(1, a, b, 1, N)
            +" "+
            tree.getMax(1, a, b, 1, N)
            );
        }
		
	}
}
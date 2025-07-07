import java.io.*;
import java.util.*;

class SegmentTree{
    long[] tree; 
    
    public SegmentTree(int N){
        int h = (int)Math.ceil(Math.log(N)/Math.log(2));
        int treeSize = (int)Math.pow(2,h+1);
        tree = new long[treeSize];
    }
    
    public long init(long[] arr, int start, int end, int treeIdx){
        
        if(start == end){
            return tree[treeIdx] = arr[start];
        }
        
        return tree[treeIdx] = init(arr, start, (start+end)/2, treeIdx*2) 
            + init(arr, (start+end)/2 + 1, end, treeIdx*2 + 1);
        
    }
    
    public void update(int arrIdx, long diff, int treeIdx, int start, int end){
        if(arrIdx < start || end < arrIdx) return;
        
        tree[treeIdx] += diff;
        
        if(start != end){
            update(arrIdx, diff, treeIdx*2, start, (start+end)/2);
            update(arrIdx, diff, treeIdx*2 + 1, (start + end)/2 +1, end);
        }
    }
    
    public long getSum(int treeIdx, int start, int end, int a, Long b){
        if(b<start || end < a) return 0;
        
        if(a <= start && end <= b){
            return tree[treeIdx];
        }
        
        return getSum(treeIdx*2, start, (start+end)/2, a, b) 
            + getSum(treeIdx*2+1, (start+end)/2+1, end, a, b);
    }
}

public class Main {
	public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N+1];
        
        for(int i=1 ; i<=N ; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        
        SegmentTree tree = new SegmentTree(N);
        tree.init(arr, 1, N, 1);
        
        for(int i=0 ; i<M+K ; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long c = Long.parseLong(st.nextToken());
            
            if(a == 1){
                tree.update(b, c - arr[b], 1, 1, N);
                arr[b] = c;
            }
            else if(a == 2){
                System.out.println(tree.getSum(1, 1, N, b, c));
            }
        }
		
	}
}
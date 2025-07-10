import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static long[] tree;
    
	public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        
        for(int i=0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> B = new HashMap<>();
        
        for(int i=0 ; i<N ; i++){
            int val = Integer.parseInt(st.nextToken());
            B.put(val, i);
        }
        
        tree = new long[2*N];
        long answer = 0L;
        
        for(int i=0 ; i<N ; i++){
            int idx = B.get(A[i]);
            
            answer += sum(idx+1, N-1);
            
            update(idx);
        }
        
        System.out.println(answer);
		
	}
    
    public static void update(int idx){
        idx += N;
        tree[idx]++;

        while(idx > 1){
            idx >>= 1;
            tree[idx] = tree[idx << 1] + tree[idx << 1 | 1];
        }
    }
    
    public static long sum(int left, int right){
        left += N;
        right += N;
        long result = 0L;
        
        while(left <= right) {
        if((left & 1) == 1) result += tree[left++];
        if((right & 1) == 0) result += tree[right--];
        left >>= 1;
        right >>= 1;
        }
        
        return result;
    }
}
import java.util.*;
import java.io.*;

class SegmentTree {
    Long[] tree;
    int N;
    int num = 1000_000_007;
    
    public SegmentTree(int N){
        tree = new Long[2*N];
        this.N = N;
    }
    
    public void init(int[] arr){
        for(int i=0 ; i<N ; i++){
            tree[i+N] = (long) arr[i];
        }
        
        for(int i=N-1 ; i>0 ; i--){
            tree[i] = (tree[i<<1]*tree[i<<1|1])%num;
        }
    }
    
    public void update(int idx, int newValue){
        idx += N;
        tree[idx] = (long) newValue;
        
        while(idx > 1){
            idx >>= 1;
            tree[idx] = (tree[idx << 1]*tree[idx << 1 | 1]) % num;
        }
    }
    
    public Long getAns(int left, int right){
        left += N;
        right += N;
        Long answer = 1L;
        
        while(left <= right){
            if(left % 2 == 1){
                answer *= tree[left];
                answer %= num;
                left++;
            }
            if(right % 2 == 0){
                answer *= tree[right];
                answer %= num;
                right--;
            }
            left >>= 1;
            right >>= 1;
        }
        
        return answer;
    }
}

public class Main {
	public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        SegmentTree tree = new SegmentTree(N);
        tree.init(arr);
        
        for(int i=0 ; i<M+K ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a==1){
                tree.update(--b, c);
                arr[b] = c;
            } 
            else if(a==2){
                System.out.println(tree.getAns(--b, --c));
            }
        }
        
		
	}
}
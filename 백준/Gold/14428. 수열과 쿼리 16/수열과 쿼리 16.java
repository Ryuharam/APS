import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int[] arr;
    static int[] tree;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        tree = new int[2*N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=1 ; i<=N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            tree[i+N-1] = i;
        }
        
        for(int i=N-1 ; i>0 ; i--){
            if(arr[tree[i<<1]]>arr[tree[i<<1|1]]){
                tree[i] = tree[i<<1|1];
            } else {
                tree[i] = tree[i<<1];
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type == 1){
                int idx = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                update(idx, value);
            }
            else{
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                System.out.println(query(l, r));
            }
        }
        
		
	}
    
    public static void update(int idx, int v){
        arr[idx] = v;
        int i = idx + N - 1;
        
        while(i>1){
            i >>= 1;
            int left = tree[i << 1];
            int right = tree[i << 1 | 1];
            
            if(arr[left] < arr[right] || 
               (arr[left] == arr[right] && left < right)) {
                tree[i] = left;
            } else {
                tree[i] = right;
            }
        }
        
    }
    
    public static int query(int l, int r){
        int idx = -1;
        l = l - 1 + N;
        r = r - 1 + N;
        
        while(l<=r){
            if(l%2==1){
                if(idx == -1 || arr[tree[l]]<arr[idx] || (arr[tree[l]] == arr[idx] && tree[l] < idx)){
                    idx = tree[l];
                }
                l++;
            }
            if(r%2==0){
                if(idx == -1 || arr[tree[r]]<arr[idx] || (arr[tree[r]] == arr[idx] && tree[r] < idx)){
                    idx = tree[r];
                }
                r--;
            }
            l >>= 1;
            r >>= 1;
        }
        
        return(idx);
    }
}
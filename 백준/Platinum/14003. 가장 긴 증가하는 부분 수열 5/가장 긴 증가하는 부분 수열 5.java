import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        int[] pos = new int[N];
        int idx = 0;

        for(int i=0 ; i<N ; i++){
            if(i == 0 || lis[idx-1] < A[i]) {
                pos[i] = idx;
                lis[idx++] = A[i];
            }else{
                int l = 0;
                int r = idx-1;
                while(l<r){
                    int mid = (l+r)/2;
                    if(lis[mid] < A[i]){
                        l = mid + 1;
                    }else{
                        r = mid;
                    }
                }
                lis[r] = A[i];
                pos[i] = r;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(idx).append("\n");

        Stack<Integer> stack = new Stack<>();
        int t = idx -1;

        for(int i=N-1 ; i>=0 ; i--){
            if(pos[i] == t){
                stack.push(A[i]);
                t--;
            }
        }

        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");

        System.out.println(sb);

    }

}

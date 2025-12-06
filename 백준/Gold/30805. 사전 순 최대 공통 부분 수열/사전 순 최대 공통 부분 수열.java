import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B =  new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st2.nextToken());
        }

        int idx_A = 0;
        int idx_B = 0;
        Queue<Integer> q = new ArrayDeque<>();

        while(idx_A < N && idx_B < M){
            int max = 0;
            for(int i = idx_A ; i<N ; i++){
                for(int j = idx_B; j<M; j++){
                    if(A[i] == B[j]) max = Math.max(max, A[i]);
                }
            }

            if(max !=0){
                q.add(max);
                while(A[idx_A] != max) idx_A++;
                while(B[idx_B] != max) idx_B++;
                idx_A++;
                idx_B++;
            }else break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(q.size()).append("\n");
        while(!q.isEmpty()){
            sb.append(q.poll()).append(" ");
        }

        System.out.println(sb);

    }
}
import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static int[] cards, parent;

    static int find (int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);
        parent[p1] = p2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 1<= M <= 4_000_000, 1<=K<=min(M, 10_000)
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        cards = new int[M];
        parent = new int[M+1];
        for(int i=0 ; i<M ; i++){
            cards[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }
        parent[M] = M;
        Arrays.sort(cards);

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<K ; i++){
            int c = Integer.parseInt(st.nextToken());
            int d = getIdx(c);

            int idx = find(d);

            sb.append(cards[idx]).append("\n");
            union(idx,idx+1);
        }

        System.out.println(sb);
    }

    static int getIdx(int n){
        int L = 0;
        int R = M-1;

        while(L < R){
            int mid = (L+R)/2;
            if(cards[mid] <= n){
                L = mid + 1;
            }else{
                R = mid;
            }
        }

        return(R);
    }

}
import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;
        parent[rootA] = rootB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                if(Integer.parseInt(st.nextToken()) == 1)
                    union(i,j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int p = find(first);

        for(int i=1 ; i<M ; i++){
            int j = Integer.parseInt(st.nextToken());

            if(p != find(j)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}

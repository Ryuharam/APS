import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] planets;
    static long[][] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        planets = new int[N][4];

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            planets[i][0] = Integer.parseInt(st.nextToken());
            planets[i][1] = Integer.parseInt(st.nextToken());
            planets[i][2] = Integer.parseInt(st.nextToken());
            planets[i][3] = i;
        }

        edges = new long[(N-1)*3][3];
        int idx = 0;

        Arrays.sort(planets, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        for(int i=0 ; i<N-1 ; i++){
            int cost = Math.abs(planets[i][0] - planets[i+1][0]);
            edges[idx++] = new long[]{planets[i][3], planets[i+1][3], cost};
        }

        Arrays.sort(planets, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        for(int i=0 ; i<N-1 ; i++){
            int cost = Math.abs(planets[i][1] - planets[i+1][1]);
            edges[idx++] = new long[]{planets[i][3], planets[i+1][3], cost};
        }

        Arrays.sort(planets, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for(int i=0 ; i<N-1 ; i++){
            int cost = Math.abs(planets[i][2] - planets[i+1][2]);
            edges[idx++] = new long[]{planets[i][3], planets[i+1][3], cost};
        }

        Arrays.sort(edges, (o1, o2) -> Long.compare(o1[2], o2[2]));
        parent = new int[N];
        for(int i=0 ; i<N ; i++){
            parent[i] = i;
        }

        int cnt = 0;
        long sum = 0;

        for(int i=0 ; i<(N-1)*3 ; i++){
            int s = (int)edges[i][0];
            int e = (int)edges[i][1];

            if(find(s) == find(e)) continue;

            union(s,e);
            sum += edges[i][2];
            cnt++;

            if(cnt == N-1) break;
        }

        System.out.println(sum);

    }

    static int find(int c){
        if(parent[c] == c) return c;
        return parent[c] = find(parent[c]);
    }

    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            parent[pa] = pb;
            return true;
        }
        return false;
    }

}

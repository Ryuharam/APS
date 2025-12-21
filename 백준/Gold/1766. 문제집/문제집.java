import java.io.*;
import java.util.*;

class Node {
    int num;
    List<Integer> child;

    Node(int num) {
        this.num = num;
        child = new ArrayList<>();
    }
}

public class Main {

    static Node[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] parent = new int[N+1];
        adj = new Node[N+1];

        for(int i=1 ; i<=N ; i++){
            adj[i] = new Node(i);
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parent[b]++;
            adj[a].child.add(b);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1 ; i<=N ; i++){
            if(parent[i] == 0){
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int curr = pq.poll();
            sb.append(curr).append(" ");
            for(int c : adj[curr].child){
                parent[c]--;
                if(parent[c] == 0){
                    pq.add(c);
                }
            }
        }
        System.out.println(sb.toString());

    }
}

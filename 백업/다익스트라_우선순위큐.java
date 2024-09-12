import java.io.*;
import java.util.*;

public class 다익스트라_우선순위큐 {
    
    static final int INF = Integer.MAX_VALUE;
    
    static String input = "6 11\r\n"
            + "0 1 4\r\n"
            + "0 2 2\r\n"
            + "0 5 25\r\n"
            + "1 3 8\r\n"
            + "1 4 7\r\n"
            + "2 1 1\r\n"
            + "2 4 4\r\n"
            + "3 0 3\r\n"
            + "3 5 6\r\n"
            + "4 3 5\r\n"
            + "4 5 12\r\n";
    
    static class Node {
        int v;
        int w;
        
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    static List<Node>[] graph;
    static int[] weights;
    static int v, e;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(input);
        v = sc.nextInt();
        e = sc.nextInt();
        graph = new ArrayList[v];
        weights = new int[v];
        
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        
        Arrays.fill(weights, INF);
        
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            
            graph[from].add(new Node(to, w));
        }
        
        dijkstra(0);
        
        System.out.println(Arrays.toString(weights));
    }
    
    static void dijkstra(int start) {
        boolean[] visited = new boolean[v];
        weights[start] = 0;
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int weight = weights[current.v];

               if (visited[current.v]) {
                continue;
               }

            visited[current.v] = true;
            
            for (Node child : graph[current.v]) {
                int nextWeight = weight + child.w;
                
                if (weights[child.v] > nextWeight) {
                    weights[child.v] = nextWeight;
                }
                
                pq.add(new Node(child.v, nextWeight));
            }
        }
    }
    
}
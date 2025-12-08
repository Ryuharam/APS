import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        LinkedList<int[]>[] adj = new LinkedList[n+1];

        for(int i = 1; i <= n; i++){
            adj[i] = new LinkedList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[s].add(new int[]{e, c});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int price = 0;
        int[] parent = new int[n+1];
        int[] cost =  new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] == end) {
                price = cur[1];
                break;
            }

            for(int[] next : adj[cur[0]]){
                if(cost[next[0]] > next[1] + cur[1] ){
                    cost[next[0]] = next[1] + cur[1];
                    parent[next[0]] = cur[0];
                    pq.add(new int[]{next[0], cur[1] + next[1]});
                }
            }
        }

        int cnt = 1;
        int cur = end;
        Stack<Integer> stack = new Stack<>();
        stack.push(cur);
        while(cur != start){
            cur = parent[cur];
            cnt++;
            stack.push(cur);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(price).append("\n").append(cnt).append("\n");

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

    }
}
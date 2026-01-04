import java.util.*;

class Node {
    int node;
    ArrayList<Integer> child;
    
    public Node(int n){
        this.node = n;
        child = new ArrayList<>();
    }
    
    public void add(int n){
        child.add(n);
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        Node[] node = new Node[n+1];
        
        for(int i=1 ; i<=n ; i++){
            node[i] = new Node(i);
        }
        
        for(int[] e : edge){
            node[e[0]].add(e[1]);
            node[e[1]].add(e[0]);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1,0});
        dist[1] = 0;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            for(int c : node[curr[0]].child){
                if(dist[c] == -1){
                    queue.add(new int[]{c,curr[1]+1}); 
                    dist[c] = curr[1] + 1;
                }
            }
        }
        
        int max = 0;
        System.out.println(Arrays.toString(dist));
        
        for(int i=1 ; i<=n ; i++){
            if(dist[i] == max){
                answer++;
            }else if(dist[i]>max){
                max = dist[i];
                answer = 1;
            }
        }
        
        
        return answer;
    }
}
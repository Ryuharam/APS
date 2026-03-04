import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N+1];

        for(int i=1 ; i<=N ; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1 ; i<=N ; i++){
            boolean[] visited = new boolean[N+1];
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            visited[i] = true;
            boolean isCycle = false;

            while(!stack.isEmpty()){
                int cur = stack.pop();
                int next = num[cur];

                if(next == i){
                    isCycle = true;
                    break;
                }

                if(!visited[next]){
                    visited[next] = true;
                    stack.push(next);
                }
            }
            if(isCycle) res.add(i);
        }

        Collections.sort(res);

        StringBuilder sb = new StringBuilder();
        sb.append(res.size()).append("\n");

        for(int i : res){
            sb.append(i).append("\n");
        }

        System.out.println(sb);

    }

}

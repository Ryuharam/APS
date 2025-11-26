import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int time = 100000;
        boolean[] visited = new boolean[100_001];
        Queue<int[]> queue = new LinkedList<>();
        visited[N] = true;
        queue.add(new int[] {N, 0});

        while (!queue.isEmpty()) {
            int[] curr =  queue.poll();
            if(curr[0] == K) {
                time = Math.min(time, curr[1]);
            }
            int nr = curr[0] + 1;
            if(nr<=100_000 && !visited[nr]) {
                visited[nr] = true;
                queue.add(new int[] {nr, curr[1] + 1});
            }
            nr = curr[0] - 1;
            if(nr>=0 && !visited[nr]) {
                visited[nr] = true;
                queue.add(new int[] {nr, curr[1] + 1});
            }
            nr = curr[0]*2;
            if(nr<=100_000 && !visited[nr]) {
                visited[nr] = true;
                queue.add(new int[] {nr, curr[1] + 1});
            }
        }
        System.out.println(time);
    }

}
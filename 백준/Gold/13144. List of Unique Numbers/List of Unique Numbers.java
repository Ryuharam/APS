import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        long ans = 0;
        boolean[] visited = new boolean[100_001];

        while(L < N){
            while(R < N && !visited[nums[R]]){
                visited[nums[R]] = true;
                R++;
            }

            ans += R - L;

            visited[nums[L]] = false;
            L++;
        }

        System.out.print(ans);

    }
}

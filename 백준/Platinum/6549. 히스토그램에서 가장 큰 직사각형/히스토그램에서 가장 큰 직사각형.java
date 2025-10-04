import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            Long[] arr = new Long[n];

            for(int i = 0; i < n; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();

            Long max = 0L;

            for(int i = 0; i < n; i++){
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                    Long height = arr[stack.pop()];
                    int width = stack.isEmpty() ? i : i-1-stack.peek();
                    max = Math.max(max, height*width);
                }
                stack.push(i);
            }

            while(!stack.isEmpty()){
                Long height = arr[stack.pop()];
                int width = stack.isEmpty() ? n : n-1-stack.peek();
                max = Math.max(max, height*width);
            }
            sb.append(String.valueOf(max)).append('\n');

        }

        System.out.println(sb);
    }
}
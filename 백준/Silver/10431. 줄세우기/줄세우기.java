import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < N ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int TC = Integer.parseInt(st.nextToken());

            int[] nums = new int[20];

            for(int i=0 ; i<20 ; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            Deque<Integer> dq = new ArrayDeque<>();

            for(int i=0 ; i<20 ; i++){
                if(dq.isEmpty() || dq.peekLast() < nums[i]) dq.add(nums[i]);

                else{
                    Stack<Integer> tmp = new Stack<>();

                    while(!dq.isEmpty() && dq.peekLast() > nums[i]){
                        tmp.add(dq.pollLast());
                        cnt++;
                    }

                    dq.add(nums[i]);

                    while(!tmp.isEmpty()){
                        dq.add(tmp.pop());
                    }
                }
            }
            sb.append(TC).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);

    }

}

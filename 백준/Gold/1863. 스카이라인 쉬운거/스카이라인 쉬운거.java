import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        stack.push(y);

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(y >= stack.peek()) stack.push(y);
            else {
                int prev = stack.pop();
                cnt++;

                while(!stack.isEmpty() && stack.peek() > y){
                    int top = stack.pop();

                    if(top != prev) {
                        prev = top;
                        cnt++;
                    }
                }
                stack.push(y);
            }

        }

        if(!stack.isEmpty()){
            int prev = 0;

            while(!stack.isEmpty()){
                int top = stack.pop();
                if(top == 0) break;

                if(top != prev){
                    cnt++;
                    prev = top;
                }
            }
        }

        System.out.println(cnt);
    }

}

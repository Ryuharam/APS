import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0){
            System.out.println("1");
            return;
        }

        st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];

        for(int i = 0; i < N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        if(N == P && S <= scores[N-1]){
            System.out.println("-1");
            return;
        }

        int rank = 1;

        for(int i = 0; i < N; i++){
            if(scores[i] > S) rank++;
            else break;
        }

        System.out.print(rank);

    }

}

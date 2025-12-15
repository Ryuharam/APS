import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int onion_1 = 1;
        int onion_2 = 1;

        for(int n=0 ; n<N; n++){
            onion_1 += A;
            onion_2 += B;

            if(onion_1 == onion_2){
                onion_2--;
            }else if(onion_1 < onion_2){
                int tmp = onion_1;
                onion_1 = onion_2;
                onion_2 = tmp;
            }
        }

        System.out.println(onion_1 + " " + onion_2);
    }

}
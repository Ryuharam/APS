import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        // d, b, q, p
        char[] upDown = {'q','p','d','b'};
        char[] leftRight = {'b','d','p','q'};
        
        for(int i=0 ; i<N ; i++){
            String line = br.readLine();
            for(int j=0 ; j<N ; j++){
                char c = line.charAt(j);
                int idx = 0;
                if(c == 'd') idx = 0;
                else if(c == 'b') idx = 1;
                else if(c == 'q') idx = 2;
                else idx = 3;
                
                sb.append(D==1? upDown[idx] : leftRight[idx]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

}
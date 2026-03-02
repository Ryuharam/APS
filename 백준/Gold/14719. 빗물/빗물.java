import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] block = new int[W];

        for(int i=0 ; i<W ; i++){
            block[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for(int i=1 ; i<W-1 ; i++){
            int l_max = 0;

            for(int j=0 ; j<=i ; j++){
                l_max = Math.max(l_max, block[j]);
            }

            int r_max = 0;

            for(int j=i ; j<W ; j++){
                r_max = Math.max(r_max, block[j]);
            }

            sum += Math.min(r_max, l_max) - block[i];

        }

        System.out.println(sum);

    }

}

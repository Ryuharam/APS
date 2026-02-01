import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[5];
        String s = br.readLine();

        for(int i=0 ; i<N ; i++){
            char c = s.charAt(i);
            if(c == 'H') cnt[0]++;
            else if(c == 'I') cnt[1]++;
            else if(c == 'A') cnt[2]++;
            else if(c == 'R') cnt[3]++;
            else if(c == 'C') cnt[4]++;
        }

        int min = N;
        for(int i=0 ; i<5 ; i++){
            min = Math.min(min, cnt[i]);
        }

        System.out.println(min);

    }

}
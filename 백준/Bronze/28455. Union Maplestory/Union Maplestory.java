import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] level = new Integer[N];

        for(int i=0 ; i<N ; i++){
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level, Collections.reverseOrder());
        
        int sum = 0;
        int exp = 0;
        for(int i=0 ; i<42 ; i++){
            if(i == N) break;
            sum += level[i];
            if(level[i] >= 250) exp += 5;
            else if(level[i] >= 200) exp += 4;
            else if(level[i] >= 140) exp += 3;
            else if(level[i] >= 100) exp += 2;
            else if(level[i] >= 60) exp += 1;
        }

        System.out.println(sum+" "+exp);

    }

}
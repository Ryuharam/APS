import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int X = 0;
        int Y = 0;

        for(int i=0 ; i<N ; i++){
            String winner = br.readLine();
            if("D".equals(winner)) X++;
            else Y++;

            if(Math.abs(X - Y) > 1) break;
        }

        System.out.println(X+":"+Y);

    }

}
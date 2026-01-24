import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long T = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long zip = 0;
        if(N % 8 == 0) zip = (N / 8 - 1) * S + N;
        else zip = (N / 8) * S + N;

        long dok = 0;
        if(M % 8 == 0) dok = T + (M / 8 - 1) * (S + 2 * T) + M;
        else dok = T + (M / 8) * (S + 2 * T) + M;

        System.out.println(zip < dok ? "Zip\n"+zip : "Dok\n"+dok);

    }

}
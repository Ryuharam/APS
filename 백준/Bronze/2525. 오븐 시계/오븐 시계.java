import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int si = Integer.parseInt(st.nextToken());
        int bun = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());
        
        bun += time;
        si += bun/60;
        bun %= 60;
        si %= 24;

        System.out.println(si+" "+bun);
    }

}
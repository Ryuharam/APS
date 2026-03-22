import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        boolean s = Integer.parseInt(st.nextToken()) == 1;
        
        if(t >= 12 && t <= 16 && !s) System.out.println(320);
        else System.out.println(280);
    }
}

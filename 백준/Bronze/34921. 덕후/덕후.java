import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int ans = 10 + 2 * (25 - A + T);

        if(ans<0) System.out.println(0);
        else System.out.println(ans);
    }
}

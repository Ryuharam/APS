import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 14579;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int res = 1;

        for(int i = a; i <= b; i++){
            int tmp = (i + 1) * i / 2;
            res *= tmp;
            res %= MOD;
        }
        res %= MOD;
        System.out.println(res);
    }

}
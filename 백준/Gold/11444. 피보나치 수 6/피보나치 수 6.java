import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;
    static long[][] first;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n =  Long.parseLong(br.readLine());
        first = new long[2][2];
        first[0][0] = 1;
        first[0][1] = 1;
        first[1][0] = 1;
        first[1][1] = 0;
        long[][] ans = pow(first ,n);

        System.out.println(ans[0][1]);

    }

    static long[][] pow (long[][] a, long n){
        if(n == 1) return first;

        long[][] tmp = pow(a, n/2);

        if(n % 2 == 0){
            return mul(tmp, tmp);
        }else{
            return mul(mul(tmp, tmp), first);
        }
    }

    static long[][] mul (long[][] a, long[][] b) {
        long[][] res = new long[2][2];

        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;

        return res;
    }

}
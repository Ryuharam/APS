import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long[] D = new long[64];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        D[0] = 1;

        long ans = getCnt(B) - getCnt(A-1);

        System.out.println(ans);
    }

    static long getCnt(long num) {
        if( num <= 0) return 0;

        int k = 0;
        while((1L<<(k+1)) <= num) k++;
        long p = 1L << k;

        return getD(k-1)+ (num-p+1)
                + getCnt(num-p);
    }

    static long getD(int n){
        if(n < 0) return 0;
        if(D[n] != 0) return D[n];
        return D[n] = getD(n-1)*2 + (1L << n);
    }
}

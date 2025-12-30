import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[2];
        A[0] = Long.parseLong(st.nextToken());
        A[1] = Long.parseLong(st.nextToken());

        long[] B = new long[2];
        B[0] = Long.parseLong(st.nextToken());
        B[1] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] C = new long[2];
        C[0] = Long.parseLong(st.nextToken());
        C[1] = Long.parseLong(st.nextToken());

        long[] D = new long[2];
        D[0] = Long.parseLong(st.nextToken());
        D[1] = Long.parseLong(st.nextToken());

        System.out.println(isIntersect(A, B, C, D) ? 1 : 0);

    }

    static long ccw(long[] A, long[] B, long[] C){
        return(B[0]-A[0])*(C[1]-A[1]) - (B[1]-A[1])*(C[0]-A[0]);
    }

    static boolean overlap(long a, long b, long c, long d){
        long up = Math.min(Math.max(a,b), Math.max(c,d));
        long down = Math.max(Math.min(a,b), Math.min(c,d));
        return down <= up;
    }

    static boolean isIntersect(long[] A, long[] B, long[] C, long[] D){
        long ab1 = ccw(A, B, C) % MOD;
        long ab2 = ccw(A, B, D) % MOD;
        long cd1 = ccw(C, D, A) % MOD;
        long cd2 = ccw(C, D, B) % MOD;

        long ab = ab1 * ab2;
        long cd = cd1 * cd2;

        if(ab == 0 && cd == 0){
            return overlap(A[0],B[0],C[0],D[0]) && overlap(A[1],B[1],C[1],D[1]);
        }

        return ab <= 0 && cd <= 0;
    }
}
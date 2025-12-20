import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());

        long[] A = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] B = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        long[] sumA = getSumList(A);
        long[] sumB = getSumList(B);

        Arrays.sort(sumA);
        Arrays.sort(sumB);

        long ans = 0;
        int L = 0;
        int R = sumB.length - 1;
        while(L < sumA.length && R >= 0) {
            long sum = sumA[L] + sumB[R];

            if(sum == T){
                long cntA = 0;
                int idx = L;
                while(idx < sumA.length && sumA[L] == sumA[idx]) {
                    cntA++;
                    idx++;
                }
                L = idx;

                long cntB = 0;
                idx = R;
                while(idx >= 0 && sumB[R] == sumB[idx]) {
                    cntB++;
                    idx--;
                }
                R = idx;

                ans += (cntA * cntB);

            }else if(sum > T){
                R--;
            }else{
                L++;
            }
        }

        System.out.println(ans);
    }

    public static long[] getSumList(long[] A) {
        int len = A.length;
        int size = len * ( len + 1 ) / 2;
        long[] res = new long[size];

        int idx = 0;
        for(int i = 0 ; i<len ; i++){
            long sum = 0;
            for(int j = i ; j < len ; j++){
                sum += A[j];
                res[idx++] = sum;
            }
        }
        return res;
    }

}
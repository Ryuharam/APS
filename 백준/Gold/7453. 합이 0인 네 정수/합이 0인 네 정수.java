import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        int size = n*n;
        long[] sum1 = new long[size];
        long[] sum2 = new long[size];

        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n ; j++) {
                sum1[idx] = A[i] + B[j];
                sum2[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(sum1);
        Arrays.sort(sum2);

        int left = 0;
        int right = size - 1;
        long ans = 0;
        while(0 <= right && left < size) {
            long sum = sum1[left] + sum2[right];
            if(sum == 0){
                long cnt1 = 0;
                int i = left;
                while(i < size && sum1[left] == sum1[i]){
                    cnt1++;
                    i++;
                }
                left = i;

                long cnt2 = 0;
                i = right;
                while(i >= 0 && sum2[right] == sum2[i]){
                    cnt2++;
                    i--;
                }
                right = i;

                ans += cnt1 * cnt2;

            }else if(sum > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(ans);
    }
}

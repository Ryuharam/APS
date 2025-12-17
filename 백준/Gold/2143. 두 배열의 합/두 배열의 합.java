import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        long[] sumA = getSubSum(A);
        long[] sumB = getSubSum(B);

        Arrays.sort(sumA);
        Arrays.sort(sumB);

        int l = 0;
        int r = sumB.length - 1;
        long ans = 0;

        while(l<sumA.length && r>=0){
            long sa = sumA[l];
            long sb = sumB[r];

            if(sa + sb == T){
                long tmpA = 0;
                while(l<sumA.length && sumA[l] == sa){
                    tmpA++;
                    l++;
                }

                long tmpB = 0;
                while(r >= 0 && sumB[r] == sb){
                    tmpB++;
                    r--;
                }

                ans += tmpA * tmpB;
            }else if(sa + sb < T){
                l++;
            }else{
                r--;
            }
        }

        System.out.println(ans);
    }

    static long[] getSubSum(int[] array){
        int n = array.length;
        int size = n*(n+1)/2;
        long[] result = new long[size];
        int idx = 0;
        for(int i=0 ; i<n; i++){
            int sum = 0;
            for(int j=i ; j<n ; j++){
                sum += array[j];
                result[idx++] = sum;
            }
        }
        return result;
    }

}
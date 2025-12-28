import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lts = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        lts[0] = arr[0];
        int len = 1;

        for (int i = 1; i < N; i++) {

            if(lts[len - 1] < arr[i]){
                lts[len++] = arr[i];
            }else{
                int lo = 0;
                int hi = len - 1;

                while(lo < hi){
                    int mid = (lo + hi) / 2;

                    if(lts[mid] < arr[i]){
                        lo = mid + 1;
                    }else{
                        hi = mid;
                    }
                }

                lts[lo] = arr[i];
            }
        }

        System.out.println(len);

    }
}
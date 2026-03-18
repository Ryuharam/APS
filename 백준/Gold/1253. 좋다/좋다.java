import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int cnt = 0;

        for(int i=0 ; i<N ; i++){
            int k = nums[i];
            int l = 0;
            int r = N-1;
            while(l<r){
                if(l == i){
                    l++;
                    continue;
                }else if(r == i){
                    r--;
                    continue;
                }

                int sum = nums[l] + nums[r];

                if(sum > k) r--;
                else if(sum < k) l++;
                else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}

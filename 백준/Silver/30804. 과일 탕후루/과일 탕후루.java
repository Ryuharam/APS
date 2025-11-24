import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] fruit = new int[N];
        for(int i = 0; i < N; i++){
            fruit[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int cnt = 0;
        int left = 0;
        int ans = 0;
        int[] type = new int[10];
        for(int right = 0; right < N; right++){
            int curr = fruit[right];
            if(type[curr] == 0){
                cnt++;
            }
            type[curr]++;

            while(cnt>2){
                int remove = fruit[left];
                type[remove]--;
                left++;
                if(type[remove] == 0){
                    cnt--;
                }
            }
            ans = Math.max(ans,right-left+1);
        }

        System.out.println(ans);

    }

}
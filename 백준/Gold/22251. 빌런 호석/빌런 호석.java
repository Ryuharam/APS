import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 1 ~ N 층
        int K = Integer.parseInt(st.nextToken());    // K 자리 수
        int P = Integer.parseInt(st.nextToken());    // 1 ~ P 개 반전
        int X = Integer.parseInt(st.nextToken());    // 원래 층
        int ans = 0;

        String[] num = {"1110111", "0010010", "1011101",
                "1011011", "0111010", "1101011",
                "1101111", "1010010", "1111111",
                "1111011"};

        String floor = String.valueOf(X);

        while(floor.length() < K) floor = "0" + floor;

        for(int i=1 ; i<=N ; i++){
            if(i == X) continue;
            
            String tmp = String.valueOf(i);
            while(tmp.length() < K) tmp = "0" + tmp;
            
            int cnt = 0;
            
            for(int j=0 ; j<K ; j++){
                String led_1 = num[floor.charAt(j) - '0'];
                String led_2 = num[tmp.charAt(j) - '0'];
                
                for(int k=0 ; k<7 ; k++){
                    if(led_1.charAt(k) != led_2.charAt(k)) cnt++;
                }
            }
            
            if(cnt <= P) ans++;
            
        }
        System.out.println(ans);
    }

}

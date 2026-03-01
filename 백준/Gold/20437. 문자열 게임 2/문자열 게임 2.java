import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0 ; t<T ; t++){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int max = 0;
            int min = W.length();

            for(char c = 'a' ; c <= 'z' ; c++){
                int l = 0;
                int h = 0;
                int cnt = 0;

                while(h < W.length()){
                    if(W.charAt(h) == c) cnt++;

                    while(cnt == K){
                        if(W.charAt(l) == c){
                            int len = h - l + 1;
                            min = Math.min(min, len);
                            max = Math.max(max, len);

                            cnt--;
                        }
                        l++;
                    }

                    h++;
                }
            }

            sb.append(max == 0 ? -1 : min+" "+max).append("\n");

        }

        System.out.println(sb);

    }

}

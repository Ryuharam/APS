import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int[] cnt = new int[26];
        int max = 0;
        char c = '?';

        for(char w : word.toCharArray()){
            int idx;

            if(w>='a'){
                idx = w-'a';
            }else{
                idx = w-'A';
            }

            if(idx > 26) return;

            cnt[idx]++;
            if(max<cnt[idx]){
                max = cnt[idx];
                c = w;
            }else if(max == cnt[idx]){
                c = '?';
            }
        }

        System.out.println(Character.toUpperCase(c));

    }
}

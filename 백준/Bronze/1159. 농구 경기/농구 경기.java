import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] names = new char[26];

        for(int i=0 ; i<N ; i++){
            String name = br.readLine();
            char c = name.charAt(0);
            int idx = c - 'a';
            names[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=0 ; i<26 ; i++){
            if(names[i] >= 5){
                flag = true;
                sb.append((char)(i + 'a'));
            }
        }

        System.out.println(flag ? sb : "PREDAJA");

    }


}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int ans = 0;
        int d = 0;

        for(int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int tmp;

            if(c == 'A'){
                tmp = 10;
            }else if(c == 'B'){
                tmp = 11;
            }else if(c == 'C'){
                tmp = 12;
            }else if(c == 'D'){
                tmp = 13;
            }else if(c == 'E'){
                tmp = 14;
            }else if(c == 'F'){
                tmp = 15;
            }else{
                tmp = Integer.parseInt(c+"");
            }

            ans += (int) (tmp * Math.pow(16, d));
            d++;
        }

        System.out.println(ans);

    }
}

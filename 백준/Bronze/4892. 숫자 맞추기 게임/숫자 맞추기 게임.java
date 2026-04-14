import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;

        while(true){
            int num = Integer.parseInt(br.readLine());

            if(num == 0) break;

            int num1 = 3 * num;
            int num2;
            
            sb.append(tc);
            tc++;

            if(num % 2 == 0){
                sb.append(". even ");
                num2 = num1 / 2;
            }else{
                sb.append(". odd ");
                num2 = (num1 + 1) / 2;
            }

            int num3 = num2 * 3;
            int num4 = num3 / 9;

            sb.append(num4).append("\n");
        }

        System.out.println(sb);

    }

}

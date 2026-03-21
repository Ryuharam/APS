import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int a = 0;
        int b = 0;

        if(s.length() == 4){
            a = Integer.parseInt(s.substring(0,2));
            b = Integer.parseInt(s.substring(2,4));
        }else if(s.length() == 3){
            if(s.charAt(1) == '0'){
                a = Integer.parseInt(s.substring(0,2));
                b = Integer.parseInt(s.substring(2,3));
            }else{
                a = Integer.parseInt(s.substring(0,1));
                b = Integer.parseInt(s.substring(1,3));
            }
        }else{
            a = Integer.parseInt(s.substring(0,1));
            b = Integer.parseInt(s.substring(1,2));
        }

        System.out.println(a+b);

    }
}

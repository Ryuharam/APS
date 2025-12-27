import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int day = 20000303;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        long tmp = 0;
        for(int i = 0; i < num.length(); i++){
            tmp = (tmp*10 + (num.charAt(i) - '0')) % day;
        }

        System.out.println(tmp);

    }
}
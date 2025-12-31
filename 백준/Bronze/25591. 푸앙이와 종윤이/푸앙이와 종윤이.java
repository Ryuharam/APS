import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a = 100 - n;
        int b = 100 - m;
        int c = 100 - (a + b);
        int d = a * b;
        int q = d / 100;
        int r = d % 100;
        int u = c + q;

        System.out.println(a+" "+b+" "+c+" "+d+" "+q+" "+r+"\n"+u+" "+r);
    }

}
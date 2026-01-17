import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cycle = 0;
        int num = N;

        while(true) {
            cycle++;
            int tmp = cal(num);
            if(tmp == N) break;
            num = tmp;
        }

        System.out.println(cycle);
    }

    static int cal(int n){
        int a = n / 10;
        int b = n % 10;

        int c = (a + b) % 10;
        return b * 10 + c;
    }

}
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        double ans = 0;
        if(M <= 30){
            ans = (double)M/2;
        }else{
            int m = M - 30;
            ans = (double)m*3/2 + 15;
        }

        System.out.printf("%.1f\n",ans);
    }

}
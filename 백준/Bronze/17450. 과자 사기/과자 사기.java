import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = "";
        String[] type = {"S","N","U"};
        double n = 0;
        double[][] tmp = new double[3][2];

        for(int i=0 ; i<3 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tmp[i][0] = Integer.parseInt(st.nextToken()) * 10; // 가격
            tmp[i][1] = Integer.parseInt(st.nextToken()) * 10; // 무게
            if(tmp[i][0] >= 5000){
                tmp[i][0] -= 500;
            }
            double p = tmp[i][1] / tmp[i][0];
            if(p > n){
                t = type[i];
                n = p;
            }
        }

        System.out.println(t);

    }

}
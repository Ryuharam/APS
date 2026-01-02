import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        int cnt = 0;

        for(int i=0 ; i<7 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            int tmp2 = Integer.parseInt(st.nextToken());
            if(tmp2 > cnt){
                name = tmp;
                cnt = tmp2;
            }
        }

        System.out.println(name);
    }

}
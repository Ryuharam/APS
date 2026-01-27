import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String N = st.nextToken();
        int L = Integer.parseInt(st.nextToken());

        if("0".equals(N)){
            sb.append("1".repeat(L-1)).append("0");
        }else{
            sb.append(N).append("1".repeat(L-1));
        }


        System.out.println(sb);
    }


}
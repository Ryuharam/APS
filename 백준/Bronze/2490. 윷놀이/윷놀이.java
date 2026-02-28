import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String[] s = {"E","A","B","C","D"};

        for(int i=0 ; i<3 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;
            for(int j=0 ; j<4 ; j++){
                if(Integer.parseInt(st.nextToken()) == 0) idx++;
            }
            sb.append(s[idx]).append("\n");
        }

        System.out.print(sb);
    }

}

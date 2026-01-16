import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0 ; i<N ; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken() +" "+ st.nextToken();
            while(st.hasMoreTokens()){
                sb.append(st.nextToken()).append(" ");
            }
            sb.append(first).append("\n");
        }
        
        System.out.println(sb);
    }


}
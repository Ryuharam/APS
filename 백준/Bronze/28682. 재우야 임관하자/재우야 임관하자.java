import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        map.put("bowling","soccer");
        map.put("soccer","bowling");

        StringBuilder sb = new StringBuilder();
        sb.append("swimming");
        for(int i=1 ; i<n ; i++){
            sb.append(" swimming");
        }

        System.out.println(sb);
        System.out.flush();

        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        sb.append(map.get(st.nextToken()));
        for(int i=1 ; i<n ; i++){
            sb.append(" ").append(map.get(st.nextToken()));
        }

        System.out.println(sb);
        System.out.flush();

    }


}
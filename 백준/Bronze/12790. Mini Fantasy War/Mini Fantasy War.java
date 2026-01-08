import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t=0 ; t<tc ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int mp = Integer.parseInt(st.nextToken());
            int damage = Integer.parseInt(st.nextToken());
            int def = Integer.parseInt(st.nextToken());
            hp += Integer.parseInt(st.nextToken());
            if(hp < 1) hp = 1;
            mp += Integer.parseInt(st.nextToken());
            if(mp < 1) mp = 1;
            damage += Integer.parseInt(st.nextToken());
            if(damage < 0) damage = 0;
            def += Integer.parseInt(st.nextToken());

            int total = hp + 5 * mp + 2 * damage + 2 * def;
            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }

}
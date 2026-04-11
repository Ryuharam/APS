import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int need = 1;
        if("Y".equals(game)) need = 1;
        else if("F".equals(game)) need = 2;
        else if("O".equals(game)) need = 3;

        int cnt = 0;

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            String name = br.readLine();
            if(set.contains(name)) continue;
            set.add(name);
            cnt++;
        }

        System.out.println(cnt/need);

    }

}

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String nickname = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char c = nickname.charAt(i);
            if('I'==c){
                sb.append("i");
            }else{
                sb.append("L");
            }
        }
        System.out.println(sb);

    }

}
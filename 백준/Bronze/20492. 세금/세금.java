import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans1 = N - (int)(N * 0.22);
        int ans2 = N - (int)(N * 0.2 * 0.22);
        System.out.println(ans1+ " "+ans2);
    }
}

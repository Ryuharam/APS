import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        // readLine()이 null을 반환하면 입력의 끝(EOF)입니다.
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int answer = 0;
        int count = 0;
        int idx = 0;

        while(idx < M-2){
            if(line.charAt(idx) == 'I' && line.charAt(idx+1) == 'O' && line.charAt(idx+2) == 'I'){
                count++;
                idx += 2;

                if(count >= N){
                    answer++;
                }

            }else {
                count = 0;
                idx++;
            }
        }

        System.out.println(answer);

    }

}
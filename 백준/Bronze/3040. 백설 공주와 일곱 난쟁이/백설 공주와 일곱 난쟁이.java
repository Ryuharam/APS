import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9];
        boolean[] lie = new boolean[9];
        
        int sum = 0;
        for(int i=0 ; i<9 ; i++){
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }
        
        sum -= 100;
        
        out : for(int i=0 ; i<9 ; i++){
            for(int j=i+1 ; j<9 ; j++){
                if(num[i]+num[j]==sum){
                    lie[i] = true;
                    lie[j] = true;
                    break out;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<9 ; i++){
            if(!lie[i]) sb.append(num[i]).append("\n");
        }
        System.out.println(sb);
    }
}
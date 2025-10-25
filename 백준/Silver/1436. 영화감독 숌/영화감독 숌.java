import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int num = 665;
        
        while(true){
            num++;
            if((num+"").contains("666")) cnt++;
            if(cnt==N) break;
        }
        
        System.out.println(num);
    }
}
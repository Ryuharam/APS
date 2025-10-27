import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int ans = -1;
        boolean flag = false;
        
        for(int i=N/5 ; i>=0 ; i--){
            int tmp = N-5*i;
            
            if(tmp%3==0){
                ans = i+tmp/3;
                flag = true;
                break;
            }
        }
        
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        for(int n=0 ; n<N ; n++){
            String s = br.readLine();
            if(s.length() >= 6 && s.length() <= 9){
                sb.append("yes");
            }else{
                sb.append("no");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String equation = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        int num = 0;
        boolean flag = false;
        
        for(int i=0 ; i<equation.length() ; i++){
            char c = equation.charAt(i);
            if('-'==c || '+'==c){
                if(flag){
                    num -= Integer.parseInt(sb.toString());
                }else{
                    if('-'==c){
                       flag = true;
                    }
                    num += Integer.parseInt(sb.toString());
                }
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        if(flag){
            num -= Integer.parseInt(sb.toString());
        }else{
            num += Integer.parseInt(sb.toString());
        }
        System.out.println(num);
    }
}
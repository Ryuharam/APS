import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String isbn = br.readLine();
        
        int sum = 0;
        int idx = 0;
        
        for(int i=0 ; i<13 ; i++){
            char c = isbn.charAt(i);
            
            if(c == '*'){
                idx = i;
            }else{
                if(i%2==0){
                    sum += Character.getNumericValue(c);
                }else{
                    sum += Character.getNumericValue(c)*3;
                }
            }
        }
        
        int answer = 0;
        
        while(true){
            if(idx%2==0 && (sum + answer)%10==0){
                break;
            }
            else if(idx%2==1 && (sum + answer*3)%10==0){
                break;
            }
            answer++;
        }
        
        System.out.println(answer);
        
    }
}
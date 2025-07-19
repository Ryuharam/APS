import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int i = 0;
        int num = 0;
        
        for(;i<3;i++){
            String str = br.readLine();
            
            if(!"Fizz".equals(str) 
               && !"Buzz".equals(str) 
               && !"FizzBuzz".equals(str)){
                num = Integer.parseInt(str);
                break;
            }
        }
        
        for(;i<3;i++){
            num++;
        }

        if(num%3==0 && num%5==0){
            System.out.println("FizzBuzz");
        }
        else if(num%3==0){
            System.out.println("Fizz");
        }
        else if(num%5==0){
            System.out.println("Buzz");
        }
        else{
            System.out.println(num);
        }
	}
}
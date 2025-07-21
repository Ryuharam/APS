import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int answer = 0;
        
        while(N>=5){
            answer += N/5;
            N /= 5;
        }
        
        System.out.println(answer);
    }
}
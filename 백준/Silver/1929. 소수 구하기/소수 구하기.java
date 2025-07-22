import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        boolean[] num = new boolean[N+1];
        num[0] = true;
        num[1] = true;
        
        for(int i=2 ; i*i<=N ; i++){
            if(!num[i]){
                for(int j=i*i ; j<=N ; j+=i){
                    num[j] = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=M ; i<=N ; i++){
            if(!num[i]) sb.append(i).append("\n");
        }
        
        System.out.println(sb);
        
    }
}
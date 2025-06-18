import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        Long a = sc.nextLong();
        Long b = sc.nextLong();
        Long v = sc.nextLong();
        
        Long answer = 1L;
        
        if(v!=a){
            answer += (v-a)/(a-b);
            
            if((v-a)%(a-b)!=0){
                answer++;
            }
        }
        
        System.out.println(answer);
        
	}
}
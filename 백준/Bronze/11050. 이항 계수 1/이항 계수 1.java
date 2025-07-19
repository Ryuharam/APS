import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] memo = new int[N+1];
        memo[0] = 1;
        for(int i=1 ; i<=N ; i++){
            memo[i] = memo[i-1]*i;
        }
        
        int answer = memo[N]/(memo[N-K]*memo[K]);
        
        System.out.println(answer);
	}
}
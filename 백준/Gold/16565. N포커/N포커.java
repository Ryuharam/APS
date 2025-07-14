import java.util.Scanner;

public class Main {
    
    static final int mod = 10007;
    static int[][] comb = new int[53][53];
        
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int ans = 0;
        
        for(int i=0 ; i<53 ; i++){
            comb[i][0] = 1;
        }
        
        for(int i=1 ; i<=52 ; i++){
            for(int j=1 ; j<=52 ; j++){
                comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
                comb[i][j] %= mod;
            }
        }
        
        for(int i=1 ; i<=13 && N-4*i >=0 ; i++){
            int tmp = (comb[52-4*i][N-4*i]*comb[13][i])%mod;
            
            if(i%2==1){
                ans = (ans + tmp) % mod;
            }else{
                ans = (ans - tmp + mod) % mod;
            }
        }
        
        System.out.println(ans);
		
	}
}
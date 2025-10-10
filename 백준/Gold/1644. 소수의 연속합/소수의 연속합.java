import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        boolean[] isPrime = eratosthenes(N);
        
        List<Integer> list = new ArrayList<>();
        for(int i=2 ; i<=N ; i++){
            if(isPrime[i]) list.add(i);
        }
        
        int size = list.size();
        int[] primes = new int[size];
        
        for(int i=0 ; i<size ; i++){
            primes[i] = list.get(i);
        }
        
        int L = 0;
        int R = 0;
        int sum = 0;
        int ans = 0;
        
        while(true){
            if(sum>=N){
                if(sum==N) ans++;
                sum -= primes[L++];
            }else{
                if(R>=size) break;
                sum += primes[R++];
            }
        }
        
        System.out.println(ans);
    }
    
    static boolean[] eratosthenes(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2 ; i*i<=n ; i++){
            if(isPrime[i]){
                for(int j=i*i ; j<=n ; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}
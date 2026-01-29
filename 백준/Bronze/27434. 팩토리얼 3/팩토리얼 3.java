import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(factorial(1, N));
    }
    
    static BigInteger factorial(int s, int e){
        BigInteger ans = BigInteger.valueOf(s);
        
        if(s<e){
            int mid = (s+e)/2;
            ans = factorial(s,mid).multiply(factorial(mid+1, e));
        }
        
        return ans;
    }

}
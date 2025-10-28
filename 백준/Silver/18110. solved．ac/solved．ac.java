import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        
        for(int i=0 ; i<n ; i++){
            scores[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(scores);
        int tmp = (int)Math.round(n*0.15);
        float sum = 0;
        for(int i=tmp ; i<n-tmp ; i++){
            sum += scores[i];
        }
        
        System.out.println(Math.round(sum/(n-2*tmp)));
        
    }
}
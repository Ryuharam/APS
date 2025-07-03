import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] numbers = new int[N];
        int[] result = new int[1000001];
        boolean[] isPresent = new boolean[1000001];
        
        for(int i=0 ; i<N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            isPresent[numbers[i]] = true;
        } 
        
        for(int i=0 ; i<N ; i++){
            for(int j=numbers[i]*2 ; j<1000001 ; j += numbers[i]){
                if(isPresent[j]){
                    result[numbers[i]]++;
                    result[j]--;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0 ; i<N ; i++){
            sb.append(result[numbers[i]]+" ");
        }
        
        System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        boolean[] counts = new boolean[2000001];
        int num = 1000000;
        
        for(int i=0 ; i<N ; i++){
            counts[Integer.parseInt(br.readLine())+num] = true;
        }
        
        for(int i=-1000000 ; i<=1000000 ; i++){
            if(counts[i+num]) sb.append(i).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
	}
}
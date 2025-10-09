import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s1 = br.readLine();
        int n1 = s1.length();
        char[] c1 = s1.toCharArray();
        
        String s2 = br.readLine();
        int n2 = s2.length();
        char[] c2 = s2.toCharArray();
        
        int[][] LCS = new int[n1+1][n2+1];
        
        for(int i=1 ; i<=n1 ; i++){
            for(int j=1 ; j<=n2 ; j++){
                if(c1[i-1]==c2[j-1]){
                    LCS[i][j] = LCS[i-1][j-1]+1;
                }else{
                    LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
                }
            }
        }
        
        System.out.println(LCS[n1][n2]);
        
    }
}
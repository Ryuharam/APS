import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        boolean[] bool = new boolean[first.length()];

        for(int i=1 ; i<N ; i++){
            String s = br.readLine();
            for(int j=0 ; j<s.length() ; j++){
                if(bool[j]) continue;
                if(s.charAt(j) != first.charAt(j)) bool[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<first.length() ; i++){
            if(bool[i]) sb.append('?');
            else sb.append(first.charAt(i));
        }

        System.out.println(sb);
    }
}

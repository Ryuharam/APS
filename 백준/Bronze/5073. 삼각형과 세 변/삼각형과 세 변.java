import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==b && b==c && c==0) break;
            if(a>=(b+c) || b>=(a+c) || c>=(a+b)) {
                sb.append("Invalid\n");
                continue;
            }
            if(a==b && b==c) sb.append("Equilateral\n");
            if(a==b && b!=c) sb.append("Isosceles\n");
            if(a!=b && b==c) sb.append("Isosceles\n");
            if(a==c && a!=b) sb.append("Isosceles\n");
            if(a!=b && b!=c && a!=c) sb.append("Scalene\n");
        }
        System.out.println(sb);
    }
}
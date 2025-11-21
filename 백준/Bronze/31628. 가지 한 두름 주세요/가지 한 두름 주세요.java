import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] color = new String[10][10];
        
        for(int i=0 ; i<10 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<10 ; j++){
                color[i][j] = st.nextToken();
            }
        }
        
        for(int i=0 ; i<10 ; i++){
            String tmp = color[i][0];
            boolean possible = true;
            for(int j=1 ; j<10 ; j++){
                if(!tmp.equals(color[i][j])){
                    possible = false;
                    break;
                }
            }
            if(possible) {
                System.out.println(1);
                return;
            }
        }
        
        for(int i=0 ; i<10 ; i++){
            String tmp = color[0][i];
            boolean possible = true;
            for(int j=1 ; j<10 ; j++){
                if(!tmp.equals(color[j][i])){
                    possible = false;
                    break;
                }
            }
            if(possible){
                System.out.println(1);
                return;
            }
        }
        
        System.out.println(0);

    }
}
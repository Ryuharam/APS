import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(bufferedReader.readLine());
        int time = 0;
        int tmp = 1;
        while(N>0){
            if(N>=tmp){
                N -= tmp;
                time++;
                tmp++;
            }else{
                tmp = 1;
            }
        }
        System.out.println(time);
    }
}
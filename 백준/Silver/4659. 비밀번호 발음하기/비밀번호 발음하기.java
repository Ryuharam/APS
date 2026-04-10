import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String pw = br.readLine();

            if("end".equals(pw)) break;

            if(hasVowal(pw) && noMoZa(pw) && noSeq(pw)) sb.append("<").append(pw).append("> is acceptable.\n");
            else sb.append("<").append(pw).append("> is not acceptable.\n");
        }

        System.out.println(sb);
    }

    static boolean hasVowal(String pw){
        return pw.contains("a") || pw.contains("e")  || pw.contains("i") || pw.contains("o") || pw.contains("u");
    }

    static boolean isVowal(char c){
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c ||'u' == c;
    }

    static boolean noMoZa(String pw){
        int idx = 0;

        while(idx < pw.length()){
            int cnt = 0;

            while(idx<pw.length() && isVowal(pw.charAt(idx))){
                cnt++;
                idx++;
            }

            if(cnt >= 3) {
                return false;
            }

            cnt = 0;

            while(idx<pw.length() && !isVowal(pw.charAt(idx))){
                cnt++;
                idx++;
            }

            if(cnt >= 3) {
                return false;
            }
        }
        return true;
    }

    static boolean noSeq(String pw){
        char c = pw.charAt(0);

        for(int i = 1; i < pw.length(); i++){
            if(c == pw.charAt(i)){
                if(c == 'e' || c == 'o'){
                    continue;
                }

                return false;
            }
            c = pw.charAt(i);
        }
        return true;
    }
}

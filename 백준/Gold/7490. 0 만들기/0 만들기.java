import java.io.*;
import java.util.*;

class Main {

    static int N, ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=0 ; t<T ; t++){
            N = Integer.parseInt(br.readLine());
            btk(1,"1");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void btk(int num, String exp){
        if(num == N){
            if(cal(exp.replaceAll(" ","")) == 0){
                sb.append(exp).append("\n");
            }
            return;
        }

        num++;
        btk(num, exp+" "+num);
        btk(num, exp+"+"+num);
        btk(num, exp+"-"+num);

    }

    static int cal(String exp){
        StringTokenizer st = new StringTokenizer(exp, "+-", true);
        int sum = Integer.parseInt(st.nextToken());

        while(st.hasMoreElements()){
            String oper = st.nextToken();
            if(oper.equals("+")){
                sum += Integer.parseInt(st.nextToken());
            }else{
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        return sum;
    }

}

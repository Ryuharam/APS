import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem> {
    int sub1;
    int sub2;

    Problem(int sub1, int sub2){
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    @Override
    public int compareTo(Problem o1) {
        if(this.sub2 == o1.sub2){
            return this.sub1 - o1.sub1;
        }else{
            return this.sub2 - o1.sub2;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Problem[] problems = new Problem[N];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(problems);

        int cnt = 0;
        int total = 0;

        for(int i=0 ; i<N ; i++){
            if(cnt >= K) break;

            if(problems[i].sub2 <= L) {
                cnt++;
                total += 140;
            }else if(problems[i].sub1 <= L){
                cnt++;
                total += 100;
            }
        }

        System.out.println(total);
    }

}
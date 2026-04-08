import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] score = new int[N][4];
        int idx = -1;

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
            score[i][3] = Integer.parseInt(st.nextToken());
            
            if(score[i][0] == K) idx = i;
        }

        int rank = 1;
        for(int i=0 ; i<N ; i++){
            if(score[i][1] > score[idx][1]){
                rank++;
            }else if(score[i][1] == score[idx][1]){
                if(score[i][2] > score[idx][2]){
                    rank++;
                }else if(score[i][2] == score[idx][2]){
                    if(score[i][3] > score[idx][3]){
                        rank++;
                    }
                }
            }
        }

        System.out.println(rank);
    }
}

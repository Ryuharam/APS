import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] space = new int[M][N];
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i=0 ; i<M ; i++){
            for(int j=i+1 ; j<M ; j++){
                if(isEven(space[i], space[j], N)) cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isEven(int[] arr1, int[] arr2, int N){
        for(int i=0 ; i<N ; i++){
            for(int j=i ; j<N ; j++){
                if((arr1[i] - arr1[j]) == 0 && arr2[i] - arr2[j] == 0) continue;
                if((arr1[i] - arr1[j]) * (arr2[i] - arr2[j]) <= 0) return false;
            }
        }
        return true;
    }

}
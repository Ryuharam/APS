import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bus = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<M ; i++){
            bus[i] = Integer.parseInt(st.nextToken());
        }

        int[][] price = new int[N][N];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 0;
        int prev = bus[0]-1;
        for(int i=1 ; i<M ; i++){
            total += price[prev][bus[i]-1];
            prev = bus[i]-1;
        }

        System.out.println(total);
    }

}
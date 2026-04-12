import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int x = -1;
        int y = -1;

        char[][] cookie = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                cookie[i][j] = line.charAt(j);

                if(x == -1 && y == -1 && cookie[i][j] == '*'){
                    x = i + 1;
                    y = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int left = 0;
        int right = 0;
        int mid = 0;
        int left_leg = 0;
        int right_leg = 0;

        for(int i = y-1 ; i >= 0 && cookie[x][i] == '*' ; i--){
            left++;
        }

        for(int i = y+1 ; i < N && cookie[x][i] == '*' ; i++){
            right++;
        }

        int mr = x+1;

        for(int i = x+1 ; i < N && cookie[i][y] == '*' ; i++){
            mid++;
            mr = i;
        }

        for(int i = mr + 1 ; i < N && cookie[i][y-1] == '*' ; i++){
            left_leg++;
        }

        for(int i = mr + 1 ; i < N && cookie[i][y+1] == '*' ; i++){
            right_leg++;
        }

        x++;
        y++;
        System.out.println(x+" "+y);
        System.out.println(left+" "+right+" "+mid+" "+left_leg+" "+right_leg);


    }

}

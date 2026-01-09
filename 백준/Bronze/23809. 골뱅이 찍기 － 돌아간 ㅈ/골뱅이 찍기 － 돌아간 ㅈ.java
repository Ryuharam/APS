import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[][] box = {
                {'@',' ',' ',' ','@'},
                {'@',' ',' ','@','X'},
                {'@','@','@','X','X'},
                {'@',' ',' ','@','X'},
                {'@',' ',' ',' ','@'}
        };
        char[][] board = new char[N*5][N*5];
        for (int i = 0; i < N*5; i++) {
            for(int j = 0; j < N*5; j++){
                board[i][j] = box[i/N][j/N];
            }
        }

        for(int i = 0; i < N*5; i++){
            for(int j = 0; j < N*5; j++){
                if(board[i][j] == 'X') continue;
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
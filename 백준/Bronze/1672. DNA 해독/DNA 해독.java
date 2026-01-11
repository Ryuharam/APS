import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String string = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<N ; i++){
            char c = string.charAt(i);
            stack.push(change(c));
        }

        // A, G, C, T
        char[] d = {'A','G','C','T'};
        char[][] c = {{'A','C','A','G'},
                {'C','G','T','A'},
                {'A','T','C','G'},
                {'G','A','G','T'}
        };

        while(stack.size() > 1){
            int An = stack.pop();
            int An1 = stack.pop();
            stack.push(change(c[An1][An]));
        }

        int i = stack.pop();
        System.out.println(d[i]);
    }

    static int change(char c){
        if(c == 'A') return 0;
        else if(c == 'G') return 1;
        else if(c == 'C') return 2;
        else return 3;
    }

}
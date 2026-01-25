import java.io.*;
import java.util.*;

public class Main {

    static int N, start, link;
    static int[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start = Integer.MAX_VALUE;
        link = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        choose(1, 1, list);

        System.out.println(Math.abs(start - link));

    }

    static void choose(int idx, int cnt, ArrayList<Integer> s_team){

        if(cnt == N/2){
            int s = cal(s_team);

            ArrayList<Integer> l_team = new ArrayList<>();
            for(int i=1 ; i<N ; i++){
                if(!s_team.contains(i)) l_team.add(i);
            }
            int l = cal(l_team);
            if(Math.abs(s - l) < Math.abs(start - link)){
                start = s;
                link = l;
                
            }
            return;
        }

        if(idx >= N) return;

        // start
        s_team.add(idx);
        choose(idx+1, cnt+1, s_team);
        s_team.remove(cnt);

        // link
        choose(idx+1, cnt, s_team);
    }

    static int cal(ArrayList<Integer> list){
        int res = 0;
        for(int i=0 ; i<N/2 ; i++){
            for(int j=0 ; j<N/2 ; j++){
                int f = list.get(i);
                int s = list.get(j);

                res += S[f][s];
            }
        }

        return res;
    }

}
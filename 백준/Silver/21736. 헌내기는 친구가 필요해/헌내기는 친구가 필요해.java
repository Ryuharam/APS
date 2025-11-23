import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] campus = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        
        int sr = 0;
        int sc = 0;
        for(int i=0 ; i<N ; i++){
            String line = br.readLine();
            for(int j=0 ; j<M ; j++){
                campus[i][j] = line.charAt(j);
                if(campus[i][j]=='I'){
                    sr = i;
                    sc = j;
                }
            }
        }
        
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(campus[curr[0]][curr[1]]=='P') cnt++;
            
            for(int d=0 ; d<4 ; d++){
                int nr = curr[0]+dr[d];
                int nc = curr[1]+dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<M 
                   && !visited[nr][nc] && campus[nr][nc]!='X'){
                    queue.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
        
        if(cnt==0){
            System.out.println("TT");
        }else{
            System.out.println(cnt);
        }
    }
}
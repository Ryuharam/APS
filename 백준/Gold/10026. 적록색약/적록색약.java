import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static char[][] colors;
    static boolean[][] visited;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        colors = new char[N][N];
        visited = new boolean[N][N];
        
        for(int i=0 ; i<N ; i++){
            String line = br.readLine();
            for(int j=0 ; j<N ; j++){
                colors[i][j] = line.charAt(j);
            }
        }
        
        int normal = 0;
        int weakness = 0;
        
        char tmp = 'W';
        
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(tmp != colors[i][j] && !visited[i][j]){
                    normal++;
                    visited[i][j] = true;
                    check(i, j, colors[i][j]);
                }
            }
        }
        
        tmp = 'W';
        visited = new boolean[N][N];
        
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(colors[i][j]=='G') colors[i][j] = 'R';
            }
        }
        
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(tmp != colors[i][j] && !visited[i][j]){
                    weakness++;
                    visited[i][j] = true;
                    check(i,j,colors[i][j]);
                }
            }
        }
        
        System.out.println(normal+" "+weakness);
        
	}
    
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    static void check(int r, int c, char color){
        for(int d=0 ; d<4 ; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(0<=nr && nr<N && nc>=0 && nc<N 
               && !visited[nr][nc]
               && colors[nr][nc]==color){
                visited[nr][nc] = true;
                check(nr, nc, color);
            }
        }
    }
}
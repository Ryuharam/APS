import java.io.*;
import java.util.*;

public class Main {

    static int h,w,cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for(int tc=0 ; tc<TC ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            cnt = 0;
            map = new char[h+2][w+2];
            visited = new boolean[h+2][w+2];

            for(int r=1 ; r<=h ; r++){
                String line = br.readLine();
                for(int c=1 ; c<=w ; c++){
                    map[r][c] = line.charAt(c-1);
                }
            }

            boolean[] keys = new boolean[26];
            String tmp = br.readLine();
            for(int i=0 ; i<tmp.length() ; i++){
                if(tmp.equals("0")) break;
                
                keys[tmp.charAt(i) - 'a'] = true;
            }

            List<int[]>[] doors = new List[26];
            for(int i=0 ; i<26 ; i++){
                doors[i] = new ArrayList<>();
            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0,0});
            visited[0][0] = true;

            while (!queue.isEmpty()){
                int[] curr = queue.poll();

                for(int d=0 ; d<4 ; d++){
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];

                    if(canMove(nr,nc)){
                        if (64 < map[nr][nc] && map[nr][nc] < 91){
                            // door
                            int door = map[nr][nc] - 65;

                            if(keys[door]) {
                                queue.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }else{
                                doors[door].add(new int[]{nr,nc});
                            }
                        }else{
                            if(96 < map[nr][nc] && map[nr][nc] < 123){
                                // key
                                int key = map[nr][nc] - 97;
                                keys[key] = true;

                                for(int[] c : doors[key]){
                                    queue.add(new int[]{c[0],c[1]});
                                    visited[c[0]][c[1]] = true;
                                }
                            } else if(map[nr][nc] == '$'){
                                cnt++;
                            }
                            queue.add(new int[]{nr,nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb);
    }

    static boolean canMove(int r, int c){
        if(r<0 || r>h+1 || c<0 || c>w+1
                || visited[r][c] || map[r][c] == '*') return false;
        return true;
    }

}
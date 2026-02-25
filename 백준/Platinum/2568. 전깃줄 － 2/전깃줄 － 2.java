import java.io.*;
import java.util.*;

class Main {

    static class Line implements Comparable<Line>{
        int a;
        int b;

        Line(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line o) {
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lines);

        List<Integer> lis = new ArrayList<>();
        int[] pos = new int[N];
        
        for(int i=0 ; i<N ; i++) {
            int b = lines[i].b;
            
            if(lis.isEmpty() || lis.get(lis.size()-1) < b){
                lis.add(b);
                pos[i] = lis.size()-1;
            } else {
                int l = 0;
                int r = lis.size() -1;
                while(l<r){
                    int mid = (l+r)/2;
                    if(lis.get(mid) < b) l = mid+1;
                    else r = mid;
                }
                lis.set(r, b);
                pos[i] = r;
            }
        }
        
        System.out.println(N - lis.size());
        
        boolean[] isLIS = new boolean[N];
        int idx = lis.size() - 1;
        for(int i=N-1 ; i>=0 ; i--){
            if(pos[i] == idx){
                isLIS[i] = true;
                idx--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            if(!isLIS[i]) sb.append(lines[i].a).append("\n");
        }
        System.out.print(sb);
        



    }

}

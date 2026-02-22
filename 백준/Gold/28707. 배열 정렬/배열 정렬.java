import java.io.*;
import java.util.*;

class Main {

    static class ArrayWrapper implements Comparable<ArrayWrapper>{
        private final int[] array;
        int cost;

        ArrayWrapper(int[] array, int cnt){
            this.array = array;
            this.cost = cnt;
        }

        public int getCost(){
            return this.cost;
        }

        @Override
        public int hashCode(){
            return Arrays.hashCode(array);
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            ArrayWrapper other = (ArrayWrapper) obj;
            return Arrays.equals(this.array, other.array);
        }

        @Override
        public int compareTo(ArrayWrapper other){
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[][] move = new int[M][3];

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(st.nextToken()) - 1;
            move[i][1] = Integer.parseInt(st.nextToken()) - 1;
            move[i][2] = Integer.parseInt(st.nextToken());
        }

        Map<ArrayWrapper, Integer> dist = new HashMap<>();
        PriorityQueue<ArrayWrapper> pq = new PriorityQueue<>();

        ArrayWrapper start = new ArrayWrapper(A, 0);
        pq.add(start);
        dist.put(start,0);

        while(!pq.isEmpty()){
            ArrayWrapper curr = pq.poll();

            if(dist.getOrDefault(curr, Integer.MAX_VALUE) < curr.cost) continue;

            for(int d=0 ; d<M ; d++){
                int[] nextArr = change(curr.array, move[d][0], move[d][1]);
                int nextCost = curr.cost + move[d][2];
                ArrayWrapper next = new ArrayWrapper(nextArr, nextCost);

                if(nextCost < dist.getOrDefault(next, Integer.MAX_VALUE)){
                    dist.put(next, nextCost);
                    pq.add(next);
                }
            }
        }

        int[] endArray = A.clone();
        Arrays.sort(endArray);
        ArrayWrapper end = new ArrayWrapper(endArray, 0);

        System.out.println(dist.getOrDefault(end, -1));
    }

    static int[] change(int[] a, int s, int e){
        int[] r = a.clone();

        int tmp = r[s];
        r[s] = r[e];
        r[e] = tmp;

        return r;
    }
}

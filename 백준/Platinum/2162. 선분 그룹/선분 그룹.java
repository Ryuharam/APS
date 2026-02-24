import java.io.*;
import java.util.*;

class Main {

    static int N, groupCnt;
    static int[][] points;
    static int[] parent;
    static int[] groupSize;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        groupCnt = N;
        points = new int[N][4];
        parent = new int[N];
        groupSize = new int[N];

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][2] = Integer.parseInt(st.nextToken());
            points[i][3] = Integer.parseInt(st.nextToken());

            parent[i] = i;
            groupSize[i] = 1;
        }

        for(int i=0 ; i<N ; i++){
            for(int j=i+1 ; j<N ; j++){
                int[] A = {points[i][0], points[i][1]};
                int[] B = {points[i][2], points[i][3]};
                int[] C = {points[j][0], points[j][1]};
                int[] D = {points[j][2], points[j][3]};

                if(isIntersect(A,B,C,D)) union(i,j);
            }
        }

        int max = 0;
        for(int i=0 ; i<N ; i++){
            if(i == parent[i]) max = Math.max(max, groupSize[i]);
        }

        System.out.println(groupCnt+"\n"+max);
    }

    static int ccw(int[] p1, int[] p2, int[] p3){
        int[] A = {p2[0]-p1[0], p2[1]-p1[1]};
        int[] B = {p3[0]-p1[0], p3[1]-p1[1]};

        int res = A[0]*B[1] - A[1]*B[0];
        if(res > 0) return 1;    // 반시계
        else if(res < 0) return -1;    // 시계
        return 0;
    }

    static boolean isIntersect(int[] A, int[] B, int[] C, int[] D) {
        int res1 = ccw(A, B, C) * ccw(A, B, D);
        int res2 = ccw(C, D, A) * ccw(C, D, B);

        // 1. 두 선분이 일반적인 교차 (X자 형태 혹은 한 점이 선분 위에 있음)
        if (res1 <= 0 && res2 <= 0) {
            // 2. 네 점이 모두 일직선상에 있는 경우 (res1==0 && res2==0)
            if (res1 == 0 && res2 == 0) {
                // 이때는 각 선분의 끝점들이 서로의 범위 안에 있는지 '범위 체크' 필수
                return Math.min(A[0], B[0]) <= Math.max(C[0], D[0]) &&
                        Math.min(C[0], D[0]) <= Math.max(A[0], B[0]) &&
                        Math.min(A[1], B[1]) <= Math.max(C[1], D[1]) &&
                        Math.min(C[1], D[1]) <= Math.max(A[1], B[1]);
            }
            // 3. 일직선은 아니지만 한 점이 선분 위에 있거나 끝점이 닿은 경우
            // (이미 위에서 res1 <= 0 && res2 <= 0 를 만족하므로 true)
            return true;
        }
        return false;
    }

    static int find(int c){
        if(parent[c] == c) return c;
        return parent[c] = find(parent[c]);
    }

    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            if(groupSize[pa] < groupSize[pb]){
                parent[pa] = pb;
                groupSize[pb] += groupSize[pa];
            }else{
                parent[pb] = pa;
                groupSize[pa] += groupSize[pb];
            }
            groupCnt -= 1;
            return true;
        }
        return false;
    }

}

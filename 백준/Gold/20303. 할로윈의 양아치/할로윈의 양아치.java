import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Group implements Comparable<Group> {
    int cnt;
    long value;

    Group(int cnt, long value) {
        this.cnt = cnt;
        this.value = value;
    }
    @Override
    public int compareTo(Group o) {
        return Integer.compare(this.cnt, o.cnt);
    }

}
public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 아이들 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        int K = Integer.parseInt(st.nextToken()); // 최소 아이들 수

        st = new StringTokenizer(br.readLine());
        long[] candy = new long[N+1];

        for(int i = 1; i <= N; i++){
            candy[i] = Long.parseLong(st.nextToken());
        }

        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        int size = 0;
        long[][] cnt = new long[N+1][2]; // 0: 그룹 내 아이 수, 1: 사탕 수
        for(int i = 1; i <= N; i++){
            if(parent[i] == i) size++;
            int p = find(i);
            cnt[p][0]++;
            cnt[p][1] += candy[i];
        }

        Group[] groups = new Group[size+1];
        groups[0] = new Group(0, 0);
        int idx = 1;
        for(int i = 1; i <= N; i++){
            if(parent[i] != i) continue;
            groups[idx++] = new Group((int)cnt[i][0], cnt[i][1]);
        }

        Arrays.sort(groups);

        long[][] dp = new long[size+1][K+1];
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= K; j++){
                if(groups[i].cnt > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-groups[i].cnt]+groups[i].value);
                }
            }
        }

        System.out.println(dp[size][K-1]);

    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);

        if(p1 == p2) return;
        else if(p1 < p2) {
            parent[p2] = p1;
        }else {
            parent[p1] = p2;
        }
    }

}
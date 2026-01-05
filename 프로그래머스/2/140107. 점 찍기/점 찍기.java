import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int a = 0 ; a <= d ; a += k){
            long b = (long)Math.sqrt((long)d*d - (long)a*a);
            
            answer += (long)b/k + 1;
        }
        return answer;
    }
}
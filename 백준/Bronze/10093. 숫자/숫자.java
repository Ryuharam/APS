import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        // 1. 큰 숫자를 다루기 위해 long 사용
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        // 2. 작은 수(s)와 큰 수(e) 구분
        long s = Math.min(a, b);
        long e = Math.max(a, b);
        
        // 3. 개수 계산 (두 수가 같으면 0, 다르면 e-s-1)
        long count = (s == e) ? 0 : e - s - 1;
        System.out.println(count);
        
        // 4. 사이의 수를 오름차순으로 출력
        StringBuilder sb = new StringBuilder();
        for (long i = s + 1; i < e; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

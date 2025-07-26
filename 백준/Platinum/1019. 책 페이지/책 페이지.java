import java.util.Scanner;

public class Main {
    
    static int[] cnt;
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int start = 1;
        int end = sc.nextInt();
        int digit = 1;
        
        cnt = new int[10];
        
        while(start <= end){
            while(start%10 != 0 && start <= end){
                count(start, digit);
                start++;
            }
            
            while(end%10 != 9 && start <= end){
                count(end, digit);
                end--;
            }
            
            if(start>end) break;
            
            start /= 10;
            end /= 10;
            
            for(int i=0 ; i<10 ; i++){
                cnt[i] += (end - start + 1) * digit;
            }

            digit *= 10;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0 ; i<10 ; i++){
            sb.append(cnt[i]).append(" ");
        }
        
        System.out.println(sb);
        
    }
    
    static void count(int num, int d){
        while(num > 0){
            cnt[num%10] += d;
            num /= 10;
        }
    }
}
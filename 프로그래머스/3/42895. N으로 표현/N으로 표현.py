def solution(N, number):
    
    if N == number:
        return 1
    
    dp = [set() for _ in range(9)] 
    dp[1] = {N}
    
    def cal(C: int, A: int, B: int):
        for a in dp[A]:
            for b in dp[B]:
                dp[C].add(a+b)
                dp[C].add(a-b)
                dp[C].add(a*b)
                if b == 0:
                    continue
                dp[C].add(a//b)
                
    
    for i in range(2, 9):
        dp[i].add(int(str(N)*i))
        for j in range(1, i):
            cal(i, j, i-j)
            
        if number in dp[i]:
            return i
            
    
    return -1
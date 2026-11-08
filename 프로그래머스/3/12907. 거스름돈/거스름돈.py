def solution(n, money):
    MOD = 1_000_000_007
    dp = [0] * (n+1)
    dp[0] = 1
    
    for m in money:
        for i in range(n+1):
            if i-m >=0:
                dp[i] += dp[i-m]
                dp[i] %= MOD
                
    return dp[n]
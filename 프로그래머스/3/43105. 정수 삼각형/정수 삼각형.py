def solution(triangle):
    N = len(triangle)
    
    dp = [[0] * N for _ in range(N)]
    dp[0][0] = triangle[0][0]
    
    for i in range(N):
        for j in range(i+1):
            if i-1 <0: 
                continue
            if j-1 < 0:
                dp[i][j] = dp[i-1][j] + triangle[i][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j]
            

    return max(dp[N-1])
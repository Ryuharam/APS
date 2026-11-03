def solution(board):
    R = len(board)
    C = len(board[0])
    
    answer = 0

    dp = [[0] * C  for _ in range(R)]
    
    for i in range(R):
        for j in range(C):
            if board[i][j] == 1:
                dp[i][j] = 1
            
                if i>0 and j>0 and board[i-1][j-1] == 1 and board[i-1][j] == 1 and board[i][j-1] == 1:
                    dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1
            
            answer = max(answer, dp[i][j])
                
    return answer * answer
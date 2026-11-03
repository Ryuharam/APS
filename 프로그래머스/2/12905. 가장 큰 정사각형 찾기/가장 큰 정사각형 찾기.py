def solution(board):
    R = len(board)
    C = len(board[0])
    
    answer = 0
    
    for i in range(R):
        for j in range(C):
            if board[i][j] == 1 and i>0 and j>0:
                board[i][j] += min(board[i-1][j-1], board[i-1][j], board[i][j-1])
            
            answer = max(answer, board[i][j])
                
    return answer * answer
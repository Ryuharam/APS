"""
1
2 12
3 13 11
4 14 15 10
5 6  7  8  9
"""

dr = [1, 0, -1]
dc = [0, 1, -1]

def solution(n):
    result = [[-1 for _ in range(n)] for _ in range(n)]
    
    total = 0
    for i in range(1, n+1):
        total += i
    
    r, c, d = 0, 0, 0
    
    for i in range(1, total+1):
        result[r][c] = i
        
        nr = r + dr[d]
        nc = c + dc[d]
        
        if 0 <= nr and nr < n and 0 <= nc and nc < n and result[nr][nc] == -1:
            r, c = nr, nc
        else:
            d = (d + 1) % 3
            r, c = r + dr[d], c + dc[d]
    
    answer = []
    
    for i in range(n):
        for j in range(n):
            if result[i][j] != -1:
                answer.append(result[i][j])
            
    return answer
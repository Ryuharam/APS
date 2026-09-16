from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    visited = [[False for _ in range(m)] for _ in range(n)]
    
    queue = deque()
    queue.append((0,0,1))
    visited[0][0] = True
    
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    while queue:
        r, c, l = queue.popleft()
        
        if r == n-1 and c == m-1:
            return l
        
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            
            if 0 <= nr and nr < n and 0 <= nc and nc < m and not visited[nr][nc] and maps[nr][nc] == 1:
                queue.append((nr, nc, l+1))
                visited[nr][nc] = True
    
    return -1
def solution(dirs):
    dr = [1, -1, 0, 0]
    dc = [0, 0, 1, -1]
    
    w_to_d = {"R": 0, "L": 1, "U": 2, "D": 3}
    
    r, c = 0, 0
    
    def is_in(x, y):
        return -5 <= x and x <= 5 and -5 <= y and y <= 5
    
    visited = set()
    
    for dir in dirs:
        d = w_to_d[dir]
        
        nr = r + dr[d]
        nc = c + dc[d]
        
        if not is_in(nr, nc):
            continue
        
        if (r, c, nr, nc) not in visited and (nr, nc, r, c) not in visited:
            set.add(visited, (r, c, nr, nc))
            
        r, c = nr, nc
            
    
    return len(visited)
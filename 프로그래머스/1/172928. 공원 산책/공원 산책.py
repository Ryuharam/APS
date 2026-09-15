def solution(park, routes):
    R, C = len(park), len(park[0])
    r, c = 0, 0
    
    for i in range(R):
        for j in range(C):
            if park[i][j] == 'S':
                r, c = i, j
    
    def is_in(a, b):
        return 0 <= a and a < R and 0 <= b and b < C and park[a][b] != 'X'
    
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    op_to_d = {'N': 0, 'S': 1, 'W': 2, 'E': 3}
    
    for route in routes:
        op, n = route.split()
        d = op_to_d[op]
        n = int(n)
        nr, nc = r, c
        flag = True
        
        for _ in range(n):
            nr = nr + dr[d]
            nc = nc + dc[d]
        
            if not is_in(nr, nc):
                flag = False
                break
        
        if flag:
            r, c = nr, nc
    

    return [r,c]
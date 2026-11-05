def solution(n, results):
    rank = [[0] * n for _ in range(n)]
    
    for win, lose in results:
        win, lose = win - 1, lose - 1
        rank[win][lose] = 1
        rank[lose][win] = -1
        
    for m in range(n):
        for s in range(n):
            for e in range(n):
                if rank[s][m] == 1 and rank[m][e] == 1:
                    rank[s][e] = 1
                    rank[e][s] = -1
    
    answer = 0
    
    for i in range(n):
        cnt = 0
        for j in range(n):
            if rank[i][j] != 0:
                cnt += 1
        if cnt == n-1:
            answer += 1
    return answer
def solution(players, callings):
    # name -> rank
    n_to_r = {}
    
    # rank -> name
    r_to_n = {}
    
    for i in range(len(players)):
        r_to_n[i] = players[i]
        n_to_r[players[i]] = i
    
    for c in callings:
        rank = n_to_r[c]
        
        if rank > 0:
            prev = r_to_n[rank-1]
            r_to_n[rank-1] = c
            r_to_n[rank] = prev
            n_to_r[prev] = rank
            n_to_r[c] = rank-1
            
    answer = []    
    
    for i in range(len(players)):
        answer.append(r_to_n[i])
        
    return answer
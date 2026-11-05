from collections import deque

def solution(priorities, location):
    pq = deque(sorted(priorities, reverse=True))
    q = deque([])
    
    N = len(priorities)
    order = [0] * N
    
    for idx, p in enumerate(priorities):
        q.append((idx, p))
        
    cnt = 1
    
    while q:
        i, curr = q.popleft()
        
        if pq[0] == curr:
            order[i] = cnt
            cnt += 1
            pq.popleft()
        else:
            q.append((i, curr))
            
        
    return order[location]
        

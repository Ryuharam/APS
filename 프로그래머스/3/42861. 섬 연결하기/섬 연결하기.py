import heapq

def solution(n, costs):
    answer = 0
    visited = 0
    link = {}
    
    for i in range(n):
        link[i] = []
    
    for a, b, c in costs:
        link[a].append([c, b])
        link[b].append([c, a])
    
    visited = visited | 1 << 0
    hq = []
    
    for c, next in link[0]:
        heapq.heappush(hq, [c, next])
    
    while hq:
        cost, curr = heapq.heappop(hq)
        
        if (1 << curr) & visited > 0:
            continue
        
        answer += cost
        visited = visited | 1 << curr
        
        if visited == (1<<n) - 1:
            break
        
        for c, next in link[curr]:
            if (1 << next) & visited > 0:
                continue
            heapq.heappush(hq, [c, next])
    
    return answer
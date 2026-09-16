import heapq
from collections import deque

def solution(tickets):
    route = {}
    
    for a, b in tickets:
        if a in route:
            route[a].append(b)
        else:
            route[a] = [b]
    
    print(route)
    
    answer = []
    tmp = []
    heapq.heappush(tmp, "ICN")
    
    while tmp:
        curr = heapq.heappop(tmp)
        answer.append(curr)
        print(tmp)
        
        if curr not in route:
            continue
        
        for next in route[curr]:
            heapq.heappush(tmp, next)
        
        route.pop(curr)
        
    return answer
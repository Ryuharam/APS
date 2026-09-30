import heapq

def solution(tickets):
    route = {}
    for a, b in tickets:
        if a in route:
            heapq.heappush(route[a], b)
        else:
            route[a] = [b]
    
    stack = ["ICN"]
    answer = []
    
    while stack:
        curr = stack[-1]
            
        if curr in route and route[curr]:
            next_city = heapq.heappop(route[curr])
            stack.append(next_city)
        else:
            answer.append(curr)
            stack.pop()
            
    return answer[::-1]
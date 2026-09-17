import heapq

def solution(tickets):
    route = {}
    
    for a, b in tickets:
        
        if a in route:
            heapq.heappush(route[a], b)
        else:
            route[a] = [b]
            
    answer = []
        
    def move(curr):
        
        while curr in route and route[curr]:
            next = heapq.heappop(route[curr])
            move(next)
        
        answer.append(curr)
    
    move("ICN")
            
    return answer[::-1]

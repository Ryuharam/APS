import heapq

def solution(scoville, K):
    cnt = 0
    
    heapq.heapify(scoville)
    
    while scoville:
        a = heapq.heappop(scoville)
        
        if a >= K:
            return cnt
        
        if not scoville:
            break
        
        b = heapq.heappop(scoville)
        
        heapq.heappush(scoville, a + b * 2)
        
        cnt += 1
    return -1
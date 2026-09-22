import heapq

def solution(k, score):
    answer = []
    result = []
    
    for s in score:
        heapq.heappush(result, s)
        if len(result) > k:
            heapq.heappop(result)
        answer.append(result[0])

    return answer
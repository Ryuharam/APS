import heapq

def solution(N, road, K):
    adj = {i: [] for i in range(1, N+1)}
    
    for a, b, c in road:
        adj[a].append((b, c))
        adj[b].append((a, c))
    
    pq = []
    heapq.heappush(pq, (0, 1))
    dist = [float('inf')] * (N+1)
    dist[1] = 0

    while pq:
        curr_dist, curr_idx = heapq.heappop(pq)
        
        if dist[curr_idx] < curr_dist:
            continue
        
        for next_idx, next_dist in adj[curr_idx]:
            sum_dist = curr_dist + next_dist
            
            if dist[next_idx] > sum_dist:
                dist[next_idx] = sum_dist
                heapq.heappush(pq, (sum_dist, next_idx))
                
    answer = 0
    for i in range(1, N+1):
        if dist[i] <= K:
            answer += 1

    return answer
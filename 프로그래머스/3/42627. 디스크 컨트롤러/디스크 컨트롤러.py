import heapq

def solution(jobs):
    jobs.sort()
    disk = []
    
    time = 0
    wait = 0
    
    idx = 0
    count = 0
    
    while count < len(jobs):
        while idx < len(jobs) and jobs[idx][0] <= time:
            heapq.heappush(disk, [jobs[idx][1], jobs[idx][0]])
            idx += 1
        
        if disk:
            curr = heapq.heappop(disk)
            time += curr[0]
            wait += time - curr[1]
            count += 1
        else:
            time = jobs[idx][0]
    
    return wait // count
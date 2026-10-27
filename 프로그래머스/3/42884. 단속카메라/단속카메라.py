def solution(routes):
    routes.sort(key = lambda x : x[1])
    last = -30001
    answer = 0
    
    for route in routes:
        if last < route[0]:
            last = route[1]
            answer += 1

    return answer
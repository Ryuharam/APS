def solution(people, limit):
    people.sort()
    
    answer = 0
    l = 0
    r = len(people) - 1
    
    while l < r:
        if people[l] + people[r] > limit:
            answer += 1
            r -= 1
        else:
            answer += 1
            l += 1
            r -= 1
    if l == r:
        answer += 1
    
    return answer
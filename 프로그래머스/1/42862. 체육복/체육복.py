def solution(n, lost, reserve):
    answer = n - len(lost)
    lost.sort()
    
    for l in lost:
        print(f"{l} 번 학생")
        if l in reserve:
            print("여분 있음")
            reserve.remove(l)
            answer += 1
        elif l > 0 and l-1 in reserve:
            print(f"{l-1} 번한테 빌림")
            reserve.remove(l-1)
            answer += 1
        elif l < n and l+1 not in lost and l+1 in reserve:
            print(f"{l+1} 번한테 빌림")
            reserve.remove(l+1)
            answer += 1
            
    return answer
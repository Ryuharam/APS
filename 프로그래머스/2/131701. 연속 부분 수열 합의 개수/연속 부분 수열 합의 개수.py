def solution(elements):
    N = len(elements)
    tmp_list = elements + elements
    
    sum_list = [0] * (N * 2 + 1)
    sum_list[0] = tmp_list[0]
    
    for i in range(1, N * 2 + 1):
        sum_list[i] = sum_list[i-1] + tmp_list[i-1]
        
    answer = set()
    
    for i in range(N):
        for j in range(1, N + 1):
            answer.add(sum_list[i+j] - sum_list[i])
    
    return len(answer)
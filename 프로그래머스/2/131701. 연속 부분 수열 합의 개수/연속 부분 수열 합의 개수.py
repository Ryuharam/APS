def solution(elements):
    N = len(elements)
    tmp_list = elements[:]
    
    for e in elements:
        tmp_list.append(e)
    
    sum_list = [0] * N * 2
    sum_list[0] = tmp_list[0]
    
    for i in range(1, N * 2):
        sum_list[i] = sum_list[i-1] + tmp_list[i]
        
    answer = set()
    
    for i in range(N):
        for j in range(N):
            set.add(answer, sum_list[i+j] - sum_list[i])
    
    return len(answer)